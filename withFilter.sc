object withFilter {
  // filter produces a new filtered collection
  // withFilter produces a view or projection also known as a non-strict collection
  // The filter is applied when the collection is iterated
  
  val xs = List(1,2,3,4)                          //> xs  : List[Int] = List(1, 2, 3, 4)
  
  def isEven(x: Int): Boolean = {
    println("isEven " + x)
    x % 2 == 0
  }                                               //> isEven: (x: Int)Boolean
  
  
  val evenList = xs.filter(isEven)                //> isEven 1
                                                  //| isEven 2
                                                  //| isEven 3
                                                  //| isEven 4
                                                  //| evenList  : List[Int] = List(2, 4)
                                                   
  // Compare to withFilter that creates a view but does not perform
  // the filtering immediately,
  val evenView = xs.withFilter(isEven)            //> evenView  : scala.collection.generic.FilterMonadic[Int,List[Int]] = scala.co
                                                  //| llection.TraversableLike$WithFilter@417e9329
  // The filtering is performed when the view is iterated
  for {
    e <- evenView
  } yield e                                       //> isEven 1
                                                  //| isEven 2
                                                  //| isEven 3
                                                  //| isEven 4
                                                  //| res0: List[Int] = List(2, 4)
 
  // Things get more interesting with chained filters
  def isGreaterThanTwo(x: Int): Boolean = {
    println("isGreaterThanTwo " + x)
    x > 2
  }                                               //> isGreaterThanTwo: (x: Int)Boolean
    
   val l = xs.filter(isEven).filter(isGreaterThanTwo)
                                                  //> isEven 1
                                                  //| isEven 2
                                                  //| isEven 3
                                                  //| isEven 4
                                                  //| isGreaterThanTwo 2
                                                  //| isGreaterThanTwo 4
                                                  //| l  : List[Int] = List(4)
                                              
   val vw = xs.withFilter(isEven).withFilter(isGreaterThanTwo)
                                                  //> vw  : scala.collection.generic.FilterMonadic[Int,List[Int]] = scala.collecti
                                                  //| on.TraversableLike$WithFilter@3b8e2477
 
  for {
    e <- vw
  } yield e                                       //> isEven 1
                                                  //| isEven 2
                                                  //| isGreaterThanTwo 2
                                                  //| isEven 3
                                                  //| isEven 4
                                                  //| isGreaterThanTwo 4
                                                  //| res1: List[Int] = List(4)
                                                  
}