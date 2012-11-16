package vidageek.scaly

import br.com.caelum.vraptor.Result
import br.com.caelum.vraptor.ComponentRegistry

@ScalyAware
class ScalyResource extends Scaly {

  Get("/abc") { (result : Result, asdf : String) =>
    println("asdf => " + asdf)
    result.include("asdf", "blablabla")
  }

}