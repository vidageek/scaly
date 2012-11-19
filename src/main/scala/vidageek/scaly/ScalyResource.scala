package vidageek.scaly

import br.com.caelum.vraptor.Result
import br.com.caelum.vraptor.ComponentRegistry

@ScalyAware
class ScalyResource extends Scaly {

  Get("/asdf")

  Get("/abc") { (asdf : String) =>
    println("asdf => " + asdf)
    render("blablabla", "")
  }

}