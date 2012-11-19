package vidageek.scaly

import br.com.caelum.vraptor.Result
import br.com.caelum.vraptor.ComponentRegistry

@ScalyAware
class ScalyResource extends Scaly with UnsafeRendering {

  Get("/asdf")

  Get("/acd")

  Get("/aff/{name}") { (name : String) =>
    println(name)
    render(name)
  }

  Get("/abc") { (asdf : String) =>
    println("asdf => " + asdf)
    render("blablabla", "")
  }

  Get("/unsafe") { () =>
    renderUnsafe("abc" -> 1, "asf" -> "asf")
  }

  Post("/unsafe") { () =>
    render
  }
}