package com.github.plippe.steam.intercom.customer

import org.scalatest.FunSpec

class TestCoordinate extends FunSpec {

  describe("Coordinate") {
    describe("distance") {
      val coordParis = Coordinate(48.85, 2.35)
      val coordNewYork = Coordinate(40.71, -74.01)

      it("should return value found online") {
        val distance = Coordinate.distance(coordParis, coordNewYork)

        assert(distance > 5837.81)
        assert(distance < 5837.82)
      }

      it("should return a positive value") {
        assert(Coordinate.distance(coordParis, coordNewYork) > 0)
        assert(Coordinate.distance(coordNewYork, coordParis) > 0)
      }
    }
  }

}
