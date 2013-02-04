object fold {
  val nums = List(1,2,3)                          //> nums  : List[Int] = List(1, 2, 3)
  
  // Folding lists - combine the elements with some operator
  // Fold left
  (0 /: nums)(_ + _)                              //> res0: Int = 6
  nums.foldLeft(0)(_ + _)                         //> res1: Int = 6
  
  /*
   * (z /: List(a,b,c))(op) equals op(op(op(z, a), b), c)
   *
   *       op
   *      /  \
   *     op   c
   *    /  \
   *   op   b
   *  /  \
   * z    a
   *
   */
  
  // Fold right
  (nums:\ 0)(_ + _)                               //> res2: Int = 6
  nums.foldRight(0)(_ + _)                        //> res3: Int = 6
  
  /*
   * (List(a,b,c) :\ z)(op) equals op(a, op(b, op(c, z)))
   *
   *       op
   *      /  \
   *     a    op
   *         /  \
   *        b    op
   *            /  \
   *           c    z
   *
   */
}