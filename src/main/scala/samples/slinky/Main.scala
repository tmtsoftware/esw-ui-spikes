import org.scalajs.dom.document
import slinky.web.ReactDOM
import slinky.web.html._

object Main {
  def main2(arguments: Array[String]): Unit = {
  ReactDOM.render(
    h1("Hello, world!"),
    document.getElementById("main")
  )
  }
}