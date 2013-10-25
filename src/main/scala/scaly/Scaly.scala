package scaly

import scaly.internal.FunctionsToRequestCode
import scaly.internal.TypeSafeRendering
import scaly.internal.AutomaticInjection
import scaly.internal.RequestMethods

trait Scaly extends FunctionsToRequestCode with TypeSafeRendering with AutomaticInjection
  with RequestMethods
