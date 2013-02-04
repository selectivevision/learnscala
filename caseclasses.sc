object caseclasses {
  abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
  
  // free constructors and accessors
  val x = Var("x")                                //> x  : caseclasses.Var = Var(x)
  x.name                                          //> res0: String = x
  val op = BinOp("+", Number(1), x)               //> op  : caseclasses.BinOp = BinOp(+,Number(1.0),Var(x))
  op.operator                                     //> res1: String = +
  op.left                                         //> res2: caseclasses.Expr = Number(1.0)
  op.right                                        //> res3: caseclasses.Expr = Var(x)
  
  // free conversion to string
  op.toString()                                   //> res4: String = BinOp(+,Number(1.0),Var(x))
  println(op)                                     //> BinOp(+,Number(1.0),Var(x))
  
  // free value based equality
  val anotherx = Var("x")                         //> anotherx  : caseclasses.Var = Var(x)
  x equals anotherx                               //> res5: Boolean = true

  // available on == which delegates to equals
  op.right == anotherx                            //> res6: Boolean = true
  
  // copy with modifications, just naming the changes
  val op2 = op.copy(operator = "-")               //> op2  : caseclasses.BinOp = BinOp(-,Number(1.0),Var(x))
  val op3 = op.copy(left = x)                     //> op3  : caseclasses.BinOp = BinOp(+,Var(x),Var(x))
  
  // free implementation of hashCode
  op.hashCode                                     //> res7: Int = -989332774
  x.hashCode                                      //> res8: Int = 630948699
  anotherx.hashCode                               //> res9: Int = 630948699
  
  // Supports pattern matching, with deconstruction
  op match {
    case BinOp(oper, _, Var(varname)) => (oper, varname)
  }                                               //> res10: (String, String) = (+,x)
  
  val e: Expr = op                                //> e  : caseclasses.Expr = BinOp(+,Number(1.0),Var(x))
  e match {
    case Var(varname) => varname
    case BinOp(oper, _, Var(varname)) => (oper, varname)
  }                                               //> res11: java.io.Serializable = (+,x)
    
}