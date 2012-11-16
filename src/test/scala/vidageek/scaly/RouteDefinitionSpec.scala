package vidageek.scaly

import br.com.caelum.vraptor.Result

@ScalyAware
class Test extends Scaly {

  Get("/abc") { (result : Result) =>
    result.include("asdf", "blablabla")
  }
}

