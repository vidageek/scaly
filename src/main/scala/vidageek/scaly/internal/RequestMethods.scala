package vidageek.scaly.internal

import scala.collection.mutable.ListBuffer
import br.com.caelum.vraptor.resource.HttpMethod

trait RequestMethods {
  val pathToCode = ListBuffer[(HttpMethod, String, RequestCode)]()

  implicit object viewOnly extends RequestCode((() => new ViewData[Unit]()).getClass)

  def Get(path : String)(implicit code : RequestCode) : Unit = pathToCode += ((HttpMethod.GET, path, code))
  def Post(path : String)(implicit code : RequestCode) : Unit = pathToCode += ((HttpMethod.POST, path, code))
  def Put(path : String)(implicit code : RequestCode) : Unit = pathToCode += ((HttpMethod.PUT, path, code))
  def Delete(path : String)(implicit code : RequestCode) : Unit = pathToCode += ((HttpMethod.DELETE, path, code))
  def Trace(path : String)(implicit code : RequestCode) : Unit = pathToCode += ((HttpMethod.TRACE, path, code))
  def Head(path : String)(implicit code : RequestCode) : Unit = pathToCode += ((HttpMethod.HEAD, path, code))

}