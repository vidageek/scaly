package scaly.view

import org.specs2.mutable.Specification

class TemplateSpecification extends Specification {

  "Template" should {
    "return html" in {
      Template[Unit]("<html>")() must_== "<html>"
    }
  }
}