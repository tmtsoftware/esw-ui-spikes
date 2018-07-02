package css.r4s

import com.github.ahnfelt.react4s._
import samples.r4s.facade.NpmReactBridge

object Main {
  def main2(arguments: Array[String]): Unit = {
    val component = Component(MainComponent)
    NpmReactBridge.renderToDomById(component, "main")
  }
}