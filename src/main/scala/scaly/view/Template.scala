package scaly.view

import scala.util.parsing.combinator.RegexParsers

object Parse extends RegexParsers {

  private def view : Parser[Any] = (html)*

  private def html = ".*".r ^^ {
    case string => StringElement(string)
  }

  def apply(content : String) = {

  }
}

case class StringElement(value : String) {
  override def toString = s""""${value}""""
}