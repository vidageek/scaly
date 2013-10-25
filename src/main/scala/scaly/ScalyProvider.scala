package scaly

import br.com.caelum.vraptor.ioc.guice.GuiceProvider
import br.com.caelum.vraptor.ComponentRegistry
import scaly.internal.ScalyStereotype

class ScalyProvider extends GuiceProvider {

  override def registerCustomComponents(registry : ComponentRegistry) = {
    registry.register(classOf[ScalyStereotype], classOf[ScalyStereotype]);
  }
}