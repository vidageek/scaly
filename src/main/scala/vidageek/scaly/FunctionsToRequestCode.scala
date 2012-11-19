package vidageek.scaly

trait FunctionsToRequestCode {

  implicit def functionToRequestCode(f : Function0[ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function1[_, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function2[_, _, ViewData[_]]) = new RequestCode(f.getClass)
  implicit def functionToRequestCode(f : Function3[_, _, _, ViewData[_]]) = new RequestCode(f.getClass)

}