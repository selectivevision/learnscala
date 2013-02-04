// Higher order functions
object hof {
  // first order function
  def double(x: Int): Int = x * 2                 //> double: (x: Int)Int
 
  // Simple immutable list, note type inference
  val xs = List(1,2,3,4)                          //> xs  : List[Int] = List(1, 2, 3, 4)
  
    
  // A higher order function takes a function as an argument or returns
  // a function. An example is map on List
  // def map[B](f: (A) => B): List[B]
  xs.map(double)                                  //> res0: List[Int] = List(2, 4, 6, 8)
  
  // Can also be written as
  xs map double                                   //> res1: List[Int] = List(2, 4, 6, 8)
  
  // The function can be defined with an anonymous function literal
  xs map((x: Int) => x * 2)                       //> res2: List[Int] = List(2, 4, 6, 8)
  
  // Or even more simply with placeholder syntax
  xs map (_ * 2)                                  //> res3: List[Int] = List(2, 4, 6, 8)
  
  
  // Immutable xs remains the same until forgotten (persistent data structure)
  xs                                              //> res4: List[Int] = List(1, 2, 3, 4)
  
  // Higher order function filter
  xs filter (_ % 2 == 0)                          //> res5: List[Int] = List(2, 4)
  
  // Another example is partition
  val (even, odd) = xs partition (_ % 2 == 0)     //> even  : List[Int] = List(2, 4)
                                                  //| odd  : List[Int] = List(1, 3)
  
  // Chaining
  xs map (_ * 2) filter (_ > 6)                   //> res6: List[Int] = List(8)
    
}