package test
sealed abstract class Expr
case class Var(name:String) extends Expr
case class Number(num:Double) extends Expr
case class UnOp(operator:String,arg:Expr) extends Expr
case class BinOp(operator:String,left:Expr,right:Expr) extends Expr



object CaseClass {
	def main(argc:Array[String]){
		val va = Var("str")
		val nu = Number(1)
		val un = UnOp("+",va)
		val ua = UnOp("+",va)
		fun(nu)
		fun(va)
		fun(un)
		any(1)
		any((1,2,3))
		any("dsfa")
		fun(ua)
	}

	//case class
	def fun(cs:Expr) = cs match{
		case Var(_) => println("string")
		case Number(_) => println("Number")
		case UnOp("+",e@_) => println(e)
		case _ => println("other")
	
	}
	
	//type case
	
	def any(an:Any) = an match{
		case int:Int => //println(int)
		case str:String => //println(str)
		case other:Any => //println(other)
	}
	

}