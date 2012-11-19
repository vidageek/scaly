package vidageek.scaly

import br.com.caelum.vraptor.Result
import org.springframework.beans.factory.annotation.Autowired

trait AutomaticInjection extends ResultInjection

trait ResultInjection {
  private var r : Result = _

  @Autowired
  def setResult(result : Result) = r = result

  def result = r
}
