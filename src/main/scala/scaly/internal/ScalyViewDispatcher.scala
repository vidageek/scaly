package scaly.internal

import br.com.caelum.vraptor.interceptor.Interceptor
import br.com.caelum.vraptor.Intercepts
import br.com.caelum.vraptor.resource.ResourceMethod
import br.com.caelum.vraptor.core.InterceptorStack
import br.com.caelum.vraptor.Result
import br.com.caelum.vraptor.view.Results
import br.com.caelum.vraptor.interceptor.OutjectResult
import br.com.caelum.vraptor.interceptor.ForwardToDefaultViewInterceptor

//@Intercepts(after = Array(classOf[OutjectResult]), before = Array(classOf[ForwardToDefaultViewInterceptor]))
class ScalyViewDispatcher(result : Result) extends Interceptor {

  override def accepts(method : ResourceMethod) = method.isInstanceOf[ScalyMethod]

  override def intercept(stack : InterceptorStack, method : ResourceMethod, resourceInstance : Object) = {
    result.use(Results.nothing) // render view
    val data = result.included.get("viewData").asInstanceOf[ViewData[_]]
    println("Should render view for path %s with parameters %s".format(method.asInstanceOf[ScalyMethod].path, data))
    stack.next(method, resourceInstance)
  }

}