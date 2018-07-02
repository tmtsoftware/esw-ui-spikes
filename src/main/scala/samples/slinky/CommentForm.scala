package samples.slinky

import org.scalajs.dom.raw.HTMLInputElement
import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class CommentForm extends Component {
  case class Props(addComment: (String, String) => Unit)
  case class State(author: String, comment: String)

  override def initialState: State = State("", "")

  def render(): ReactElement = {
    div(
      h3("CommentForm"),
      form(onSubmit := (e => {
        e.preventDefault()
        props.addComment(state.author, state.comment)
        setState(state.copy("", ""))
      }))(
        input(onChange := (v => setState(state.copy(author = v.target.asInstanceOf[HTMLInputElement].value))),
              value := state.author),
        input(onChange := (v => setState(state.copy(comment = v.target.asInstanceOf[HTMLInputElement].value))),
              value := state.comment),
        button("Post Comment#")
      )
    )
  }

}
