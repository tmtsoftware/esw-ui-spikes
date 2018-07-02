package samples.slinky

import org.scalajs.dom
import slinky.web.ReactDOM

object Main {
  def main(args: Array[String]): Unit = {
    ReactDOM.render(
      MainComponent(),
      dom.document.getElementById("main")
    )
  }
}
