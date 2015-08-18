package com.github.plippe.steam.intercom

import sbt._
import sbt.Keys._

object Dependencies {
  lazy val common = Seq(scalaTest)

  lazy val customer = common ++ Seq(json4sNative)

  val scalaTest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
  val json4sNative = "org.json4s" %% "json4s-native" % "3.2.11"
}
