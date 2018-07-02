package samples.slinky

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class Comment extends StatelessComponent {
  case class Props(author: String, comment: String)

  def render(): ReactElement = {
    div(
      p(s"Comment Author - ${props.author}"),
      p(s"Comment - ${props.comment}")
    )
  }
}
