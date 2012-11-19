package vidageek.scaly

import scala.collection.mutable.ListBuffer
import br.com.caelum.vraptor.resource.HttpMethod

trait RequestMethods {
  val pathToCode = ListBuffer[(HttpMethod, String, RequestCode)]()

  implicit object viewOnly extends RequestCode((() => new ViewData[Unit]()).getClass)

  def Get(path : String)(implicit code : RequestCode) : Unit = pathToCode += ((HttpMethod.GET, path, code))
}