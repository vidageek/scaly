package scaly.view

import org.specs2.mutable.Specification

class TemplateSyntaxSpec extends Specification {

  "Template Syntax" should {
    "allow string only content" in {
      Parse("""abc""") must_== Seq(StringElement("abc"))
    }
  }

}