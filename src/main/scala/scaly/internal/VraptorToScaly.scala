package scaly.internal

import br.com.caelum.vraptor.http.route.Route
import br.com.caelum.vraptor.http.MutableRequest

import java.lang.reflect.Method

import br.com.caelum.vraptor.resource.ResourceMethod
import br.com.caelum.vraptor.ComponentRegistry
import br.com.caelum.vraptor.ioc.ApplicationScoped
import br.com.caelum.vraptor.http.route.Router
import br.com.caelum.vraptor.ioc.StereotypeHandler
import br.com.caelum.vraptor.ioc.guice.GuiceProvider
import scaly.Scaly
import scaly.ScalyAware

import java.lang.annotation.Annotation

class ScalySpringProvider extends GuiceProvider {

  override def registerCustomComponents(registry : ComponentRegistry) = {
    registry.register(classOf[ScalyStereotype], classOf[ScalyStereotype]);
  }
}

@ApplicationScoped
class ScalyStereotype(componentRegistry : ComponentRegistry, router : Router) extends StereotypeHandler {

  override def stereotype = classOf[ScalyAware]
  override def handle(clazz : Class[_]) = {
    println("analyzing scaly class %s".format(clazz.getName))
    val scaly = clazz.newInstance().asInstanceOf[Scaly]
    scaly.pathToCode.foreach { entry =>
      val (httpMethod, path, code) = entry
      val clazz = code.clazz
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

case class ScalyRoute(delegate : Route, path : String) extends Route {

  def resourceMethod(request : MutableRequest, uri : String) = new ScalyMethod(delegate.resourceMethod(request, uri), uri)

  def canHandle(uri : String) = delegate.canHandle(uri)
  def canHandle(clazz : Class[_], method : Method) = delegate.canHandle(clazz, method)
  def allowedMethods = delegate.allowedMethods
  def urlFor(clazz : Class[_], m : Method, params : Object*) = delegate.urlFor(clazz, m, params)
  def getPriority = delegate.getPriority
  def getOriginalUri = delegate.getOriginalUri
}

case class ScalyMethod(delegate : ResourceMethod, path : String) extends ResourceMethod {
  def getMethod = delegate.getMethod
  def getResource = delegate.getResource
  def containsAnnotation(annotation : Class[_ <: Annotation]) = delegate.containsAnnotation(annotation)
}

