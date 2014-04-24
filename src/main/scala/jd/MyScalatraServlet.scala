package jd

import com.mongodb.casbah.Imports._
import org.scalatra._
import scalate.ScalateSupport
import scala.xml.Node

class MyScalatraServlet(mongoColl:MongoCollection) extends JdStack {
    
  post("/mongodb"){
    val key = params("key")
    val value = params("value")
    val newObj = MongoDBObject(key -> value)
    mongoColl.insert(newObj)
  }
  
  get("/") {
//一定记得定义文件类型
    contentType="text/html"
    val kk:String = "<p>first blood</p>"
//指定view模板和layout，将值赋给view
//    jade("empty.jade","layout"->"WEB-INF/templates/layouts/default.jade","aa"->kk)
    jade("empty.jade","aa"->kk)
  }

  get("/query/:key/:value"){
    val q = MongoDBObject(params("key") -> params("value"))
    for(x <- mongoColl.findOne(q)) yield x
  }
  
}
