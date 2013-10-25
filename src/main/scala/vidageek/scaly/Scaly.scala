package vidageek.scaly

import vidageek.scaly.internal.AutomaticInjection

import vidageek.scaly.internal.RequestMethods

import vidageek.scaly.internal.TypeSafeRendering

import vidageek.scaly.internal.FunctionsToRequestCode

trait Scaly extends FunctionsToRequestCode with TypeSafeRendering with AutomaticInjection
  with RequestMethods
