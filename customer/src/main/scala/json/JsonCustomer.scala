package com.github.plippe.steam.intercom.customer.json

import java.io.File
import org.json4s._
import org.json4s.native.JsonMethods._
import scala.io.Source

import com.github.plippe.steam.intercom.customer.{ Customer, Coordinate }

case class JsonCustomer(
  user_id: Int,
  name: String,
  latitude: String,
  longitude: String)

object JsonCustomer {
  /**
   * Converts a json customer to a normal customer
   * @param json The json customer to convert
   * @return The customer
   */
  def toCustomer(json: JsonCustomer): Customer = {
    val coordinate = Coordinate(json.latitude.toDouble, json.longitude.toDouble)
    Customer(json.user_id, json.name, coordinate)
  }

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

  /**
   * Obtain customers found in a json file
   * @param file The json file to read
   * @return The customers found
   */
  def fromFile(file: File): Traversable[JsonCustomer] = {
    Source.fromFile(file)
      .getLines()
      .flatMap(JsonCustomer.fromString)
      .toTraversable
  }
}
