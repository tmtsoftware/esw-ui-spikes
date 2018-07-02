package samples.slinky

import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class Notification extends StatelessComponent {

  case class Props(commentListLength: Int)

  def render(): ReactElement = {
    div(
      if (props.commentListLength > 2) {
        h1("Too many Comments. Reduce those")
      } else {
        h1()
      }
    )
  }
}
