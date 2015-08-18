package com.github.plippe.steam.intercom.customer

case class Customer(
  id: Int,
  name: String,
  coordinate: Coordinate)

object Customer {
  /**
   * Calculate the distance in km between a custumer and a coordine
   * @param custumer The custumer whos coordinates will be used
   * @param coordinate The second coordinate
   * @return The distance in km
   */
  def distance(custumer: Customer, coordinate: Coordinate): Double =
    Coordinate.distance(custumer.coordinate, coordinate)
}
