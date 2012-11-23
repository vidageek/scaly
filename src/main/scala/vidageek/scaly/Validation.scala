package vidageek.scaly

trait Validation {

  def expect(validations : Assertion*) = {}

  implicit def addVerification(i18nKey : Key) = new {
    def ==>(f : => Boolean) = new Assertion(f, i18nKey)
  }

}

class Assertion(validation : => Boolean, i18nKey : Key)