object stream {
  // A Stream is like a list except that its elements are computed lazily
  val l = 1 :: 2 :: 3 :: List.empty               //> l  : List[Int] = List(1, 2, 3)
  
  val str = 1 #:: 2 #:: 3 #:: Stream.empty        //> str  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  // A stream can be infinitely long!
  def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)
                                                  //> fibFrom: (a: Int, b: Int)Stream[Int]
  
  val fibs = fibFrom(1, 1).take(10)               //> fibs  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  fibs.toList                                     //> res0: List[Int] = List(1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
}