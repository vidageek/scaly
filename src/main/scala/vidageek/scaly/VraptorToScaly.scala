package vidageek.scaly

import br.com.caelum.vraptor.http.route.Route
import br.com.caelum.vraptor.http.MutableRequest
import java.lang.reflect.Method
import br.com.caelum.vraptor.resource.ResourceMethod
import java.lang.annotation.Annotation
import br.com.caelum.vraptor.ioc.spring.SpringProvider
import br.com.caelum.vraptor.ComponentRegistry

class ScalyProvider extends SpringProvider {

  override def registerCustomComponents(registry : ComponentRegistry) = {
    registry.register(classOf[ScalyStereotype], classOf[ScalyStereotype]);
  }
}

class ScalyRoute(delegate : Route, path : String) extends Route {

  def resourceMethod(request : MutableRequest, uri : String) = new ScalyMethod(delegate.resourceMethod(request, uri), uri)

  def canHandle(uri : String) = delegate.canHandle(uri)
  def canHandle(clazz : Class[_], method : Method) = delegate.canHandle(clazz, method)
  def allowedMethods = delegate.allowedMethods
  def urlFor(clazz : Class[_], m : Method, params : Object*) = delegate.urlFor(clazz, m, params)
  def getPriority = delegate.getPriority
  def getOriginalUri = delegate.getOriginalUri
}

class ScalyMethod(delegate : ResourceMethod, val path : String) extends ResourceMethod {
  def getMethod = delegate.getMethod
  def getResource = delegate.getResource
  def containsAnnotation(annotation : Class[_ <: Annotation]) = delegate.containsAnnotation(annotation)
}

