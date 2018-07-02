package samples.slinky

import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.{div, _}

@react class CommentBox extends Component {

  case class Props(updateCommentLengthInNotification: Int => Unit)
  case class State(showComments: Boolean, comments: List[CommentModel])

  override def initialState: State = State(showComments = false, List.empty[CommentModel])

  def addCommentsToState(): (String, String) => Unit = { (author, comment) =>
    setState(state.copy(comments = state.comments :+ CommentModel(author, comment)), () => {
      props.updateCommentLengthInNotification(state.comments.length)
    })
  }

  def render(): ReactElement = {
    val shownCommentModels = if (state.showComments) state.comments else List() //List.empty

    val buttonText = if (state.showComments) "Hide Comments" else "Show Comments"

    div(
      h3("Comments"),
      button(
        onClick := (e => {
          e.preventDefault()
          setState(state.copy(showComments = !state.showComments))
        })
      )(buttonText),
      ul(
        shownCommentModels.map { comment =>
          li(Comment(comment.author, comment.comment))
        }: _*
      ),
      CommentForm(addComment = addCommentsToState()),
    )
  }
}

case class CommentModel(author: String, comment: String)
