package vidageek.scaly

import br.com.caelum.vraptor.Result
import br.com.caelum.vraptor.ComponentRegistry

@ScalyAware
class ScalyResource extends Scaly with UnsafeRendering {

  Get("/asdf")

  Get("/acd")

  Get("/abc") { (asdf : String) =>
    println("asdf => " + asdf)
    render("blablabla", "")
  }

}