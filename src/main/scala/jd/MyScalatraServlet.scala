package jd

import org.scalatra._
import scalate.ScalateSupport
import scala.xml.Node

class MyScalatraServlet extends JdStack {

  get("/") {
//一定记得定义文件类型
    contentType="text/html"
    val kk:String = "<p>first blood</p>"
//指定view模板和layout，将值赋给view
//    jade("empty.jade","layout"->"WEB-INF/templates/layouts/default.jade","aa"->kk)
    jade("empty.jade","aa"->kk)
  }
  
}
