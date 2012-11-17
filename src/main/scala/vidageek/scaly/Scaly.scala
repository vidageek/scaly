package vidageek.scaly

import scala.annotation.implicitNotFound
import scala.collection.mutable.ListBuffer

import org.springframework.beans.factory.annotation.Autowired

import br.com.caelum.vraptor.{ComponentRegistry, Result}
import br.com.caelum.vraptor.http.route.Router
import br.com.caelum.vraptor.ioc.{ApplicationScoped, StereotypeHandler}
import br.com.caelum.vraptor.resource.HttpMethod

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
      val clazz = entry._3.clazz
      val method = methodDef(clazz)
      println("registering route: %s => %s".format(path, clazz.getName))
      componentRegistry.register(clazz, clazz)
      val builder = router.builderFor(path)
      builder.`with`(httpMethod)
      builder.is(clazz, method)
      router.add(builder.build)
    }
  }

  def methodDef(clazz : Class[_]) = clazz.getDeclaredMethods().filter(_.getName == "apply").head
}

class ViewData[T](data : T)
class RequestCode(val clazz : Class[_])

trait FunctionsToRequestCode {

  implicit def functionToRequestCode(f : Function0[ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function1[_, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function2[_, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function3[_, _, _, ViewData[_]]) = new RequestCode(f.getClass)

}

trait Rendering {
  def render[T](data : T) = new ViewData[(T)]((data))
  def render[T, E](data : Tuple2[T, E]) = new ViewData(data)
}

trait ResultInjection {
  private var r : Result = _

  @Autowired
  def setResult(result : Result) = r = result

  def result = r
}

trait RequestMethods {
  val pathToCode = ListBuffer[(HttpMethod, String, RequestCode)]()
  def Get(path : String)(code : RequestCode) = pathToCode += ((HttpMethod.GET, path, code))
}