object lazyvals {
  object Demo {
    lazy val x = { println("initializing x"); "done" }
  }
  
  val d = Demo                                    //> d  : lazyvals.Demo.type = lazyvals$Demo$@1e38d900
  
  // Initialized at first use..
  d.x                                             //> initializing x
                                                  //| res0: String = done
  // ..only
  d.x                                             //> res1: String = done
}