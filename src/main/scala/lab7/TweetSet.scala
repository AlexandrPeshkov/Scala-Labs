package main.scala.lab7

case class Tweet(val user: String, val text: String, val retweets: Int) {
  override def toString: String =
    "User: " + user + "\n" +
      "Text: " + text + " [" + retweets + "]"
}

abstract class TweetSet {

  def filter(p: Tweet => Boolean): TweetSet = filterAcc(p, new Empty)

  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet

  def union(that: TweetSet): TweetSet = {
    if (that.isEmpty) this
    else incl(that.head) union that.tail
  }

  def descendingByRetweet: TweetList = {
    if (isEmpty) new Nil
    else {
      val max = findMax
      new Cons(max, remove(max).descendingByRetweet)
    }
  }

  def incl(tweet: Tweet): TweetSet

  def remove(tweet: Tweet): TweetSet

  def contains(tweet: Tweet): Boolean

  def foreach(f: Tweet => Unit): Unit = {
    if (!this.isEmpty) {
      f(this.head)
      this.tail.foreach(f)
    }
  }

  def isEmpty: Boolean
  def head: Tweet
  def tail: TweetSet

  def findMax0(curr: Tweet): Tweet =
    if (this.isEmpty) curr
    else if (this.head.retweets > curr.retweets) this.tail.findMax0(this.head)
    else this.tail.findMax0(curr)

  def findMax: Tweet =
    this.tail.findMax0(this.head)

}

class Empty extends TweetSet {

  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = acc

  def contains(tweet: Tweet): Boolean = false

  def incl(tweet: Tweet): TweetSet = new NonEmpty(tweet, new Empty, new Empty)

  def remove(tweet: Tweet): TweetSet = this

  def isEmpty = true

  def head = throw new Exception("Empty.head")

  def tail = throw new Exception("Empty.tail")
}

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet {

  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = {
    val leftright = left.filterAcc(p, right.filterAcc(p, acc))
    if (p(elem)) leftright.incl(elem)
    else leftright
  }

  def contains(x: Tweet): Boolean =
    if (x.text < elem.text) left.contains(x)
    else if (elem.text < x.text) right.contains(x)
    else true

  def incl(x: Tweet): TweetSet = {
    if (x.text < elem.text) new NonEmpty(elem, left.incl(x), right)
    else if (elem.text < x.text) new NonEmpty(elem, left, right.incl(x))
    else this
  }

  def remove(tw: Tweet): TweetSet =
    if (tw.text < elem.text) new NonEmpty(elem, left.remove(tw), right)
    else if (elem.text < tw.text) new NonEmpty(elem, left, right.remove(tw))
    else left.union(right)

  def isEmpty = false
  def head = if (left.isEmpty) elem else left.head
  def tail = if (left.isEmpty) right else new NonEmpty(elem, left.tail, right)
}


trait TweetList{
  def + (tw: Tweet): TweetList
  def head: Tweet
  def tail: TweetList
  def isEmpty: Boolean
  def foreach(f: Tweet => Unit): Unit = {
    if (!this.isEmpty) {
      f(this.head)
      this.tail.foreach(f)
    }
  }
}

class Nil extends TweetList {
  def + (tw: Tweet) = new Cons(tw, new Nil)
  def head: Tweet = throw new Exception("head of EmptyList")
  def tail: TweetList = throw new Exception("tail of EmptyList")
  def isEmpty: Boolean = true
  override def toString = "EmptyList"
}

class Cons(val head: Tweet, val tail: TweetList) extends TweetList {
  def + (tw: Tweet): TweetList =
    new Cons(head, tail + tw)

  def isEmpty: Boolean = false
  override def toString =
    "NonEmptyTrending(" + head.retweets + ", " + tail + ")"
}

object GoogleVsApple {
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")

  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

  def byKeywords(words: List[String]) = (t:Tweet) => words.exists( (term) => t.text.contains(term) )

  val googleTweets: TweetSet = JsonTweetReader.allTweets.filter( byKeywords(google) )

  val appleTweets: TweetSet = JsonTweetReader.allTweets.filter( byKeywords(apple))

  val trending: TweetList = googleTweets.union(appleTweets).descendingByRetweet
}
