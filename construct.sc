object construct {
  // Constructors
  // Only the primary class constructor can call the base class constructor
  // Auxiliary constructors must invoke another constructor as their first action
  // This must be one that comes textually before it in the class definition
  
  class Base(b: Int) {
     println("Base")
  }
  
  // Note that the class itself takes parameters
  class MakeMe(n: Int, d: Int) extends Base(n) {
    val numer: Int = n
    val denom: Int = d
    println("MakeMe primary constructor")
    
    def this(n: Int) = {
      this(n, 1)
      println("auxiliary1")
    }
    
    def this() = {
      this(1)
      println("auxiliary2")
    }
  }

  val mm1 = new MakeMe(1,2)                       //> Base
                                                  //| MakeMe primary constructor
                                                  //| mm1  : construct.MakeMe = construct$MakeMe@2887e18f
  val mm2 = new MakeMe(5)                         //> Base
                                                  //| MakeMe primary constructor
                                                  //| auxiliary1
                                                  //| mm2  : construct.MakeMe = construct$MakeMe@70e98812
  val mm3 = new MakeMe()                          //> Base
                                                  //| MakeMe primary constructor
                                                  //| auxiliary1
                                                  //| auxiliary2
                                                  //| mm3  : construct.MakeMe = construct$MakeMe@73e48fa7
                                                    
}