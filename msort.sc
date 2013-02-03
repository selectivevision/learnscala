object msort {
  // Merge sort illustrates divide and conquer, currying and recursion
  
  // msort takes two parameter lists
  def msort[T](less: (T,T) => Boolean)(xs: List[T]): List[T] = {
    // nested function merge
    def merge(xs: List[T], ys: List[T]): List[T] = {
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    }
    
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }                                               //> msort: [T](less: (T, T) => Boolean)(xs: List[T])List[T]
  
  val xs = List(5,1,3,7,5,9)                      //> xs  : List[Int] = List(5, 1, 3, 7, 5, 9)
  
  def less(x: Int, y: Int): Boolean = x < y       //> less: (x: Int, y: Int)Boolean
  
  msort(less)(xs)                                 //> res0: List[Int] = List(1, 3, 5, 5, 7, 9)
  
  msort((x: Int, y: Int) => x < y)(xs)            //> res1: List[Int] = List(1, 3, 5, 5, 7, 9)
  
  msort[Int](_ < _)(xs)                           //> res2: List[Int] = List(1, 3, 5, 5, 7, 9)
  
  val intsort = msort[Int](_ < _) _               //> intsort  : List[Int] => List[Int] = <function1>
  
  intsort(xs)                                     //> res3: List[Int] = List(1, 3, 5, 5, 7, 9)
}