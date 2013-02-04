object xml {
  // XML can be entered as a literal anywhere an expression is valid
  val x1 = <a>Some XML</a>                        //> x1  : scala.xml.Elem = <a>Some XML</a>
  
  // You can evaluate Scala code within an XML literal by using {}
  val x2 = <a>{"hello"+", world"}</a>             //> x2  : scala.xml.Elem = <a>hello, world</a>
  
  val x3 = <a>{{double brances to escape}}</a>    //> x3  : scala.xml.Elem = <a>{double brances to escape}</a>

  // Scala takes care of escaping special characters
  val x4 = <a>{"<tricky>"}</a>                    //> x4  : scala.xml.Elem = <a>&lt;tricky&gt;</a>
  
  // Which avoids potential security holes
  val x5 = <a>{"<a>potential security hole</a>"}</a>
                                                  //> x5  : scala.xml.Elem = <a>&lt;a&gt;potential security hole&lt;/a&gt;</a>
  
  // toXML method
  //
  
  x1.text                                         //> res0: String = Some XML
  x5.text                                         //> res1: String = <a>potential security hole</a>
  
  // Extracting sub-elements
  val x6 = <a><b><c>hello</c><c>world</c></b><b>bb</b></a>
                                                  //> x6  : scala.xml.Elem = <a><b><c>hello</c><c>world</c></b><b>bb</b></a>
  x6.text                                         //> res2: String = helloworldbb
  
  // Find b's one level down
  x6 \ "b"                                        //> res3: scala.xml.NodeSeq = NodeSeq(<b><c>hello</c><c>world</c></b>, <b>bb</b>
                                                  //| )
  
  // No c's one level down
  x6 \ "c"                                        //> res4: scala.xml.NodeSeq = NodeSeq()
  
  // Find c's at any depth
  x6 \\ "c"                                       //> res5: scala.xml.NodeSeq = NodeSeq(<c>hello</c>, <c>world</c>)
  
  x6 \ "b" \ "c"                                  //> res6: scala.xml.NodeSeq = NodeSeq(<c>hello</c>, <c>world</c>)
  
  
}