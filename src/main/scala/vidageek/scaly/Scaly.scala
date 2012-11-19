package vidageek.scaly

import br.com.caelum.vraptor.ComponentRegistry
import br.com.caelum.vraptor.http.route.Router
import br.com.caelum.vraptor.ioc.{ApplicationScoped, StereotypeHandler}

trait Scaly extends FunctionsToRequestCode with Rendering with AutomaticInjection with RequestMethods

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
      val method = apply(clazz)
      println("registering route: %s => %s".format(path, clazz.getName))
      componentRegistry.register(clazz, clazz)
      val builder = router.builderFor(path)
      builder.`with`(httpMethod)
      builder.is(clazz, method)
      router.add(new ScalyRoute(builder.build, path))
    }
  }

  private def apply(clazz : Class[_]) = clazz.getDeclaredMethods().filter(_.getName == "apply").head
}
