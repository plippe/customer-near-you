package com.github.plippe.steam.intercom.customer

case class Coordinate(
  latitude: Double,
  longitude: Double)

object Coordinate {
  /**
   * Calculate the distance in km between two coordinates
   * @param a The first coordinate
   * @param b The second coordinate
   * @return The distance in km
   */
  def distance(a: Coordinate, b: Coordinate): Double = {
    import scala.math._

    val earthRadius: Double = 6371d

    val deltaLatitude: Double = (a.latitude - b.latitude).toRadians
    val deltaLongitude: Double = (a.longitude - b.longitude).toRadians

    val delta: Double = pow(sin(deltaLatitude / 2), 2) +
      pow(sin(deltaLongitude / 2), 2) *
      cos(a.latitude.toRadians) *
      cos(b.latitude.toRadians)

    2 * asin(sqrt(delta)) * earthRadius
  }
}
