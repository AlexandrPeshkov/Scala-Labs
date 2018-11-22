package main.scala.lab7
import spray.json._

object TweetJsonProtocol extends DefaultJsonProtocol {
  implicit val personFormat: JsonFormat[Tweet] = jsonFormat3(Tweet)
}

object JsonTweetReader {

  object ParseTweets {
    import TweetJsonProtocol._
    def getTweetData(user: String, source: String): List[Tweet] = {
      source.parseJson.convertTo[List[Tweet]]
    }
  }

  def toTweetSet(l: List[Tweet]): TweetSet = {
    l.foldLeft(new Empty: TweetSet)(_.incl(_))
  }

  val sites = List("gizmodo", "TechCrunch", "engadget", "amazondeals", "CNET", "gadgetlab", "mashable")

  private val gizmodoTweets = JsonTweetReader.ParseTweets.getTweetData("gizmodo", TweetData.gizmodo)
  private val techCrunchTweets = JsonTweetReader.ParseTweets.getTweetData("TechCrunch", TweetData.TechCrunch)
  private val engadgetTweets = JsonTweetReader.ParseTweets.getTweetData("engadget", TweetData.engadget)
  private val amazondealsTweets = JsonTweetReader.ParseTweets.getTweetData("amazondeals", TweetData.amazondeals)
  private val cnetTweets = JsonTweetReader.ParseTweets.getTweetData("CNET", TweetData.CNET)
  private val gadgetlabTweets = JsonTweetReader.ParseTweets.getTweetData("gadgetlab", TweetData.gadgetlab)
  private val mashableTweets = JsonTweetReader.ParseTweets.getTweetData("mashable", TweetData.mashable)

  private val sources = List(gizmodoTweets, techCrunchTweets, engadgetTweets, amazondealsTweets, cnetTweets, gadgetlabTweets, mashableTweets)

  val tweetSets: List[TweetSet] = sources.map(tweets => toTweetSet(tweets))

  private def unionOfAllTweetSets(curSets: List[TweetSet], acc: TweetSet): TweetSet =
    if (curSets.isEmpty) acc
    else unionOfAllTweetSets(curSets.tail, acc.union(curSets.head))

  val allTweets: TweetSet = unionOfAllTweetSets(tweetSets, new Empty)
}
