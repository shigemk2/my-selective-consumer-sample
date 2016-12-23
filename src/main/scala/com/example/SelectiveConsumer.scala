package com.example

import akka.actor._

object SelectiveConsumerDriver extends CompletableApp(3) {
}

case class MessageTypeA()
case class MessageTypeB()
case class MessageTypeC()

class SelectiveConsumer(
                         consumerOfA: ActorRef,
                         consumerOfB: ActorRef,
                         consumerOfC: ActorRef) extends Actor {
  def receive = {
    case message: MessageTypeA => consumerOfA forward message
    case message: MessageTypeB => consumerOfB forward message
    case message: MessageTypeC => consumerOfC forward message
  }
}

class ConsumerOfMessageTypeA extends Actor {
  def receive = {
    case message: MessageTypeA =>
      println(s"ConsumerOfMessageTypeB: $message")
      SelectiveConsumerDriver.completedStep()
  }
}