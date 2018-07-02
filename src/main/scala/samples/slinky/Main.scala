package samples.slinky

import org.scalajs.dom
import slinky.web.ReactDOM

import scala.scalajs.js.annotation.JSExportTopLevel

object Main {
  @JSExportTopLevel("entrypoint.main")
  def main(args: Array[String]): Unit = {
    ReactDOM.render(
      MainComponent(),
      dom.document.getElementById("main")
    )
  }
}
