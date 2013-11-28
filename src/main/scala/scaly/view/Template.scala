package scaly.view

import scala.util.parsing.combinator.RegexParsers

object Template {
  def apply[T](template : String) : T => String = {
    null

  }
}

object Parse extends RegexParsers {

  private def view : Parser[List[Token]] = (variableAccess | html)+

  private def html = ".+".r ^^ {
    case string => Html(string)
  }

  private def variableAccess = """@(\s+)""".r ^^ {
    case variable => Variable(variable)
  }

  def apply(content : String) = {
    parseAll(view, content)
  }
}

trait Token {
  def asScala : String
}

case class Html(value : String) extends Token {
  override def asScala = s""""${value}""""
}

case class Variable(name : String) extends Token {
  override def asScala = s""""${name}""""
}
