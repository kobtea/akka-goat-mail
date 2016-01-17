import akka.actor.{ActorRef, Props, ActorSystem, Actor}

case class Mail(message: String)

case class Start(target: ActorRef)

case class Goat(name: String) extends Actor {

  def say(msg: String) = println(name + ": " + msg)

  def eat(): Unit = this.say("om nom nom nom...")

  def receive = {
    case Start(ar) =>
      ar ! Mail("Hello!")
    case Mail(s) =>
      this.eat()
      sender() ! Mail("What did you write about?")
  }

}

object GoatMail extends App {
  val goatPool = ActorSystem("goat-pool")
  val whiteGoat = goatPool.actorOf(Props(classOf[Goat], "white-goat"))
  val blackGoat = goatPool.actorOf(Props(classOf[Goat], "black-goat"))

  whiteGoat ! Start(blackGoat)
}
