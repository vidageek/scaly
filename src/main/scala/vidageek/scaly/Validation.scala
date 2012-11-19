package vidageek.scaly

trait Validation {

  def expect(validations : Assertion[_]*) = {}

  implicit def addVerification[T](t : T) = new {
    def ==>(f : T => Boolean) = new Assertion(t, f)
  }

}

class Assertion[T](value : T, validation : T => Boolean)