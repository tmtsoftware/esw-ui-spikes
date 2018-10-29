package samples.slinky

import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.{div, h1}

@react class MainComponent extends Component {
  case class State(commentListLength: Int)
  type Props = Unit

  override def initialState: State = State(0)

  def updateState: Int => Unit = { length =>
    setState(state.copy(length))
  }

  override def render(): ReactElement = {
    div(
      h1("Slinky application"),
      CommentBox(updateState),
      Notification(state.commentListLength)
    )
  }

}
