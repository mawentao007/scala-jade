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

    contentType="text/html"
    val poemTitle = params("poemTitle")
    val poemContent = params("poemContent")
    val newObj = MongoDBObject("poemTitle" -> poemTitle,"poemContent"->poemContent)
    mongoColl.insert(newObj)
    redirect("/query/null")
  }
  
  get("/edit"){
    contentType="text/html"
    jade("edit.jade")
  }

  
  get("/") {
//一定记得定义文件类型
    contentType="text/html"
    val face:String = "欢迎来到古诗词网站"
    jade("index.jade","face"->face)
//指定view模板和layout，将值赋给view
//    jade("empty.jade","layout"->"WEB-INF/templates/layouts/default.jade","aa"->kk)

  }


  get("/query/:key"){
        contentType = "text/html"
        var list = new ListBuffer[List[String]]
        val allDoc = mongoColl.find()  
        var pTitle:String = ""
        var pId:String = ""
        var poemContent = ""
        var poemTitle = ""
        for (i <- allDoc){
          pId = i.getAs[ObjectId]("_id") map (_.toString) getOrElse "No answer"
          pTitle = i.getOrElse("poemTitle","No answer").toString()
          val lt = List(pId,pTitle)
          list += lt
          if(pId == params("key").toString()){
            poemContent = i.getOrElse("poemContent","No answer").toString()
            poemTitle = pTitle
          }

          
        }

        jade("content.jade","list" -> list.toList,"poemContent" -> poemContent,"poemTitle" -> poemTitle);
  }
  
}

