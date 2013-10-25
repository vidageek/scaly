package scaly.internal

class RequestCode(val clazz : Class[_])

trait FunctionsToRequestCode {

  implicit def callByNameToRequestCode(f : => ViewData[_]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function0[ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function1[_, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function2[_, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function3[_, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function4[_, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function5[_, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function6[_, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function7[_, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function8[_, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function9[_, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function10[_, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function11[_, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function12[_, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function13[_, _, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function14[_, _, _, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function15[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function16[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function17[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function18[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function19[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function20[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function21[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function22[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, ViewData[_]]) = new RequestCode(f.getClass)

}