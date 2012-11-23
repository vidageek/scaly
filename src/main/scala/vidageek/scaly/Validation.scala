package vidageek.scaly

trait Validation {

  def expect(validations : Assertion*) = {}

  implicit def addVerification(f : => Boolean) = new Assertion(f)

}

class Assertion(validation : => Boolean)