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
