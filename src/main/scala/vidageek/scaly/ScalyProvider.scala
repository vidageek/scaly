package vidageek.scaly

import br.com.caelum.vraptor.ioc.spring.SpringProvider
import br.com.caelum.vraptor.ComponentRegistry
import br.com.caelum.vraptor.ioc.StereotypeHandler

class ScalyProvider extends SpringProvider {

  override def registerCustomComponents(registry : ComponentRegistry) = {
    registry.register(classOf[ScalyStereotype], classOf[ScalyStereotype]);
  }

}