package vidageek.scaly

import scala.collection.mutable.Map

import br.com.caelum.vraptor.ComponentRegistry
import br.com.caelum.vraptor.http.route.Router
import br.com.caelum.vraptor.ioc.{ ApplicationScoped, StereotypeHandler }

trait Scaly extends FunctionsToRequestCode {

  val pathToCode = Map[String, RequestCode]()

  def Get(path : String)(code : RequestCode) = pathToCode += path -> code

}

@ApplicationScoped
class ScalyStereotype(componentRegistry : ComponentRegistry, router : Router) extends StereotypeHandler {

  override def stereotype = classOf[ScalyAware]
  override def handle(clazz : Class[_]) = {
    println("analyzing scaly class %s".format(clazz.getName))
    val scaly = clazz.newInstance().asInstanceOf[Scaly]
    scaly.pathToCode.foreach { entry =>
      val path = entry._1
      val clazz = entry._2.clazz
      val method = methodDef(clazz)
      println("registering route: %s => %s".format(path, clazz.getName))
      componentRegistry.register(clazz, clazz)
      val builder = router.builderFor(path)
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