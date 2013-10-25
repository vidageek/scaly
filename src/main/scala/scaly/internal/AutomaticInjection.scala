package scaly.internal

import br.com.caelum.vraptor.Result
import com.google.inject.Inject

trait AutomaticInjection extends ResultInjection

trait ResultInjection {
  private var r : Result = _

  @Inject
  def setResult(result : Result) = r = result

  def result = r
}
