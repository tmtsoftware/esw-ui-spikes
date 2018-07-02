package css.r4s

import com.github.ahnfelt.react4s._

case class Comment(cssClass: P[CssClass], author: P[String], comment: P[String]) extends Component[NoEmit] {

  override def render(get: Get): ElementOrComponent = {
    E.div(
      CommentCss,
      get(cssClass),
      E.p(Text("Comment Author - " + get(author))),
      E.p(Text("Comment -" + get(comment)))
    )
  }
}

object CommentCss extends CssClass(
  S.color("red")
)

