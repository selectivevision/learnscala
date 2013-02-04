object regex {
  // """ strings avoid need to escape \'s
  val dateP1 = """(\d\d\d\d)-(\d\d)-(\d\d)""".r   //> dateP1  : scala.util.matching.Regex = (\d\d\d\d)-(\d\d)-(\d\d)
  
  val dateP1(year, month, day) = "2011-07-15"     //> year  : String = 2011
                                                  //| month  : String = 07
                                                  //| day  : String = 15
  
  val copyright: String = dateP1 findFirstIn "Date of this document: 2011-07-15" match {
  case Some(dateP1(year, month, day)) => "Copyright "+year
  case None                           => "No copyright"
  }                                               //> copyright  : String = Copyright 2011
  
  val copyright2: Option[String] = for {
  dateP1(year, month, day) <- dateP1 findFirstIn "Last modified 2011-07-15"
  } yield year                                    //> copyright2  : Option[String] = Some(2011)
  
  def hasDate(text: String): Boolean = (dateP1 findFirstIn text).nonEmpty
                                                  //> hasDate: (text: String)Boolean
                                                  
  hasDate("none here")                            //> res0: Boolean = false
  
  hasDate("Last modified 2011-07-15")             //> res1: Boolean = true
  
  val dateP2 = new scala.util.matching.Regex("""(\d\d\d\d)-(\d\d)-(\d\d)""", "year", "month", "day")
                                                  //> dateP2  : scala.util.matching.Regex = (\d\d\d\d)-(\d\d)-(\d\d)
                                                  
  val months = Map( 1 -> "Jan", 2 -> "Feb", 3 -> "Mar",
                    4 -> "Apr", 5 -> "May", 6 -> "Jun",
                    7 -> "Jul", 8 -> "Aug", 9 -> "Sep",
                   10 -> "Oct", 11 -> "Nov", 12 -> "Dec")
                                                  //> months  : scala.collection.immutable.Map[Int,String] = Map(5 -> May, 10 -> 
                                                  //| Oct, 1 -> Jan, 6 -> Jun, 9 -> Sep, 2 -> Feb, 12 -> Dec, 7 -> Jul, 3 -> Mar,
                                                  //|  11 -> Nov, 8 -> Aug, 4 -> Apr)
    
  import scala.util.matching.Regex.Match
  def reformatDate(text: String) = dateP2 replaceAllIn ( text, (m: Match) =>
    "%s %s, %s" format (months(m group "month" toInt), m group "day", m group "year")
  )                                               //> reformatDate: (text: String)String
  
  reformatDate("Last modified 2011-07-15 2013-01-21")
                                                  //> res2: String = Last modified Jul 15, 2011 Jan 21, 2013
}