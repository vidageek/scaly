package vidageek.scaly

import java.lang.reflect.Method
import scala.collection.mutable.ListBuffer
import org.springframework.beans.factory.annotation.Autowired
import br.com.caelum.vraptor.{ ComponentRegistry, Result }
import br.com.caelum.vraptor.http.MutableRequest
import br.com.caelum.vraptor.http.route.{ Route, Router }
import br.com.caelum.vraptor.ioc.{ ApplicationScoped, StereotypeHandler }
import br.com.caelum.vraptor.resource.{ HttpMethod, ResourceMethod }
import java.lang.annotation.Annotation

trait Scaly extends FunctionsToRequestCode with Rendering with ResultInjection with RequestMethods

@ApplicationScoped
class ScalyStereotype(componentRegistry : ComponentRegistry, router : Router) extends StereotypeHandler {

  override def stereotype = classOf[ScalyAware]
  override def handle(clazz : Class[_]) = {
    println("analyzing scaly class %s".format(clazz.getName))
    val scaly = clazz.newInstance().asInstanceOf[Scaly]
    scaly.pathToCode.foreach { entry =>
      val httpMethod = entry._1
      val path = entry._2
      val clazz = classFor(entry._3.clazz, path)
      val method = methodDef(clazz)
      println("registering route: %s => %s".format(path, clazz.getName))
      componentRegistry.register(clazz, clazz)
      val builder = router.builderFor(path)
      builder.`with`(httpMethod)
      builder.is(clazz, method)
      router.add(new ScalyRoute(builder.build, path))
    }
  }

  def methodDef(clazz : Class[_]) = clazz.getDeclaredMethods().filter(_.getName == "apply").head
  def classFor(clazz : Class[_], path : String) = {
    if (!clazz.isAssignableFrom(classOf[ViewOnly]))
      clazz
    else
      (() => new ViewData[Unit]()).getClass
  }
}

class ViewData[T](data : T)
class RequestCode(val clazz : Class[_])

trait Rendering {
  def render[T](data : T) = new ViewData[(T)]((data))
  def render[T, E](data : (T, E)) = new ViewData(data)
}

trait ResultInjection {
  private var r : Result = _

  @Autowired
  def setResult(result : Result) = r = result

  def result = r
}

trait ViewOnly

trait RequestMethods {
  val pathToCode = ListBuffer[(HttpMethod, String, RequestCode)]()
  implicit object viewOnly extends RequestCode(classOf[ViewOnly])
  def Get(path : String)(implicit code : RequestCode) : Unit = pathToCode += ((HttpMethod.GET, path, code))
}