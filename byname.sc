object byname {
  // Give the parameter a type starting with => instead of () =>
  // to make it a by name parameter which is not evaluated before the call
  // but rather on use within the function
  var assertionsEnabled = true                    //> assertionsEnabled  : Boolean = true
 
  def simpleAssert(predicate: Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError                    //> simpleAssert: (predicate: Boolean)Unit
  
  def byNameAssert(predicate: => Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError                    //> byNameAssert: (predicate: => Boolean)Unit
  
  def five(): Int = {
    println("five")
    5
  }                                               //> five: ()Int
  
  simpleAssert(five() > 3)                        //> five
  byNameAssert(five() > 3)                        //> five
  
  assertionsEnabled = false
  simpleAssert(five() > 3)                        //> five
  byNameAssert(five() < 3)
  
  // The expression is not evaluated before the call
}