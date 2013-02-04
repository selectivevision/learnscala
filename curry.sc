object curry {
  // A curried function is applied to multiple argument lists
  def curriedSum(x: Int)(y: Int) = x + y          //> curriedSum: (x: Int)(y: Int)Int
  
  curriedSum(1)(2)                                //> res0: Int = 3
  
  // A partially applied function is one applied to fewer than all its
  // parameter lists
  val paf1 = curriedSum(1) _                      //> paf1  : Int => Int = <function1>
  
  paf1(2)                                         //> res1: Int = 3
  
  // Think of a function of one argument that returns a function
  // of the next argument
  def first(x: Int) = (y: Int) => x + y           //> first: (x: Int)Int => Int
  
  val paf2 = first(1)                             //> paf2  : Int => Int = <function1>
  paf2(2)                                         //> res2: Int = 3
  
  first(1)(2)                                     //> res3: Int = 3
}