package vidageek.scaly

import br.com.caelum.vraptor.Result
import br.com.caelum.vraptor.ComponentRegistry

@ScalyAware
class ScalyResource extends Scaly {

  Get("/abc") { (asdf : String) =>
    println("asdf => " + asdf)
    view << "asdf" -> "blablabla"
  }

}