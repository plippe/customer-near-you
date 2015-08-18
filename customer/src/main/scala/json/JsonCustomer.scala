package com.github.plippe.steam.intercom.customer.json

import org.json4s._
import org.json4s.native.JsonMethods._

import com.github.plippe.steam.intercom.customer.{ Customer, Coordinate }

case class JsonCustomer(
  user_id: Int,
  name: String,
  latitude: String,
  longitude: String)

object JsonCustomer {
  /**
   * Obtain the json customer found in a json string
   * @param jsonStr The json string to read
   * @return The json customer found
   */
  def fromString(jsonStr: String): Option[JsonCustomer] = {
    implicit val formats = DefaultFormats

    val json = parse(jsonStr)
    json.extractOpt[JsonCustomer]
  }
}
