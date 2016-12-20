package com.example

import akka.actor._

object SelectiveCustomerDriver extends CompletableApp(3) {
}

case class MessageTypeA()
case class MessageTypeB()
case class MessageTypeC()
