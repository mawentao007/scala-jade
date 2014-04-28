package jd

import com.mongodb.casbah.Imports._
import org.scalatra._
import scalate.ScalateSupport
import scala.xml.Node
import scala.collection.mutable.ListBuffer


class MyScalatraServlet(mongoColl:MongoCollection) extends JdStack {

/*  private def show(x:Option[String]) = x match {
    case Some(s) => s
    case None => "No answer"
  }
*/
//  class Message(title:String,content:String,_id:String){
//    val poemTitle = title
//    val poemContent = content
//    val id = _id
//  }

    
  post("/edit"){
    val poemTitle = params("poemTitle")
    val poemContent = params("poemContent")
    val newObj = MongoDBObject("poemTitle" -> poemTitle,"poemContent"->poemContent)
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


  get("/:key"){
        contentType = "text/html"
        var list = new ListBuffer[List[String]]
        val allDoc = mongoColl.find()  
        for (i <- allDoc){
          val lt = List(i.getOrElse("poemTitle", "No answer").toString(),
                                    i.getOrElse("poemContent", "No answer").toString(),
                                    i.getAs[ObjectId]("_id") map (_.toString) getOrElse "No answer")
          list += lt
        }
        jade("content.jade","list" -> list.toList);
  }
  
}

