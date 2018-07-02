package css.r4s

import com.github.ahnfelt.react4s._

case class CommentBox() extends Component[NoEmit] {

  val commentModelsS = State(List(CommentModel("Autor1", "Comment1"), CommentModel("Autor2", "Comment2")))

  override def render(get: Get): ElementOrComponent = {
    val shownCommentModels = get(commentModelsS)

    E.div(
      E.h3(Text("Comments")),
      E.ul(
        Tags(
          shownCommentModels.map { comment =>
            E.li(Component(Comment, CommentBoxCss, comment.author, comment.comment))
          }
        )
      )
    )
  }
}

case class CommentModel(author: String, comment: String)

object CommentBoxCss extends CssClass(
  S.color("green"),
)

