package samples.CommentListExample.commentList

import com.github.ahnfelt.react4s._
import samples.CommentListExample.CommentsStore
import samples.CommentListExample.commentList.CommentForm.AddComment

case class CommentBox() extends Component[NoEmit] {

  val showCommentsS = State(false)
  val commentStore  = CommentsStore(this)

  override def render(get: Get): ElementOrComponent = {
    val showComments                      = get(showCommentsS)
    val commentModels: List[CommentModel] = get(commentStore)

    val buttonText = if (showComments) "Hide Comments" else "Show Comments"

    val commentNodes = if (showComments) {
      E.ul(Tags(commentModels.map { comment =>
        E.li(Component(Comment, comment.author, comment.comment))
      }))
    } else {
      E.ul()
    }

    def handleCommentFormEvents(msg: CommentForm.Msg): Unit = msg match {
      case AddComment(author, comment) =>
        CommentsStore.emit(CommentBox.AddComment(author, comment))
    }

    E.div(
      E.h3(Text("Comments")),
      E.button(Text(buttonText), A.onClick { e =>
        e.preventDefault()
        showCommentsS.set(!showComments)
      }),
      commentNodes,
      E.div(Component(CommentForm).withHandler(handleCommentFormEvents))
    )
  }

}

object CommentBox {
  sealed trait Msg
  case class AddComment(author: String, comment: String) extends Msg
}

case class CommentModel(author: String, comment: String)
