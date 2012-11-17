package vidageek.scaly

import scala.collection.mutable.Map
import br.com.caelum.vraptor.ComponentRegistry
import br.com.caelum.vraptor.http.route.Router
import br.com.caelum.vraptor.ioc.{ ApplicationScoped, StereotypeHandler }
import scala.collection.mutable.ListBuffer
import br.com.caelum.vraptor.resource.HttpMethod
import java.util.HashSet
import scala.collection.immutable.Set
import scala.collection.JavaConverters._
import br.com.caelum.vraptor.Result
import org.springframework.beans.factory.annotation.Autowired

trait Scaly extends FunctionsToRequestCode {

  private var r : Result = _

  @Autowired
  def setResult(result : Result) = r = result

  def result = r

  def view = new ScalyView(result)

  val pathToCode = ListBuffer[(HttpMethod, String, RequestCode)]()

  def Get(path : String)(code : RequestCode) = pathToCode += ((HttpMethod.GET, path, code))
}

class ScalyView(result : Result) {

  def <<(data : Tuple2[String, Any]) = result.include(data._1, data._2)

}

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

case class RequestCode(clazz : Class[_])

trait FunctionsToRequestCode {

  implicit def a(f : Function0[_]) = RequestCode(f.getClass)
  implicit def a(f : Function1[_, _]) = RequestCode(f.getClass)
  implicit def a(f : Function2[_, _, _]) = RequestCode(f.getClass)
  implicit def a(f : Function3[_, _, _, _]) = RequestCode(f.getClass)

}