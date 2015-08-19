package com.github.plippe.steam.intercom

import sbt._
import sbt.Keys._

object Dependencies {
  lazy val common = Seq(scalaTest)

  lazy val customer = common ++ Seq(json4sNative, typeSafeConfig, typeSafeLogging, slf4j)

  val scalaTest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
  val json4sNative = "org.json4s" %% "json4s-native" % "3.2.11"
  val typeSafeConfig = "com.typesafe" % "config" % "1.3.0"
  val typeSafeLogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
  val slf4j = "org.slf4j" % "slf4j-simple" % "1.7.12"

}
