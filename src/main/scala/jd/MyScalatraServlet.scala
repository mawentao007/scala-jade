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
  def getList:List[List[String]]={

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
        }
        list.toList
  }
    
  post("/edit"){

    contentType="text/html"
    val poemTitle = params("poemTitle")
    val poemContent = params("poemContent")
    val newObj = MongoDBObject("poemTitle" -> poemTitle,"poemContent"->poemContent)
    mongoColl.insert(newObj)
    redirect("/")
  }

  get("/edit/:key"){
    contentType="text/html"
    mongoColl.remove(MongoDBObject("_id"->new ObjectId(params("key"))))
    redirect("/")


  }

  get("/edit"){
    contentType="text/html"
    jade("edit.jade","list"->getList,"viewName"->"edit.jade")
  }

  

  get("/query/:key"){
        contentType = "text/html"
        val poemCol = mongoColl.findOne(MongoDBObject("_id"->new ObjectId(params("key"))))
        var poemContent:String = ""
        var poemTitle:String = ""
        for(col <- poemCol){
           poemContent = col.getOrElse("poemContent","No answer").toString()
           poemTitle = col.getOrElse("poemTitle","No answer").toString()
        }
        jade("content.jade","list" -> getList,"poemContent" -> poemContent,"poemTitle" -> poemTitle,"poemId"-> params("key"),"viewName"->"content.jade");
  }


  get("/"){
        contentType = "text/html"
        jade("titleList","list"->getList,"viewName"->"index.jade")

  }




  
}

