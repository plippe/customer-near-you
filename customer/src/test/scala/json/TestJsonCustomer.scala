package com.github.plippe.steam.intercom.customer.json

import org.scalatest.FunSpec

class TestJsonCustomer extends FunSpec {

  describe("JsonCustomer") {
    describe("fromString") {
      it("should convert single record into a customer") {
        val json = """{
          "latitude": "52.986375",
          "user_id": 12,
          "name": "Christina McArdle",
          "longitude": "-6.043701"
        }"""

        val customer = JsonCustomer.fromString(json)
        assert(customer.nonEmpty)
        assert(customer.get.user_id === 12)
        assert(customer.get.name === "Christina McArdle")
        assert(customer.get.latitude === "52.986375")
        assert(customer.get.longitude === "-6.043701")
      }

      it("should not convert invalid record, missing user_id") {
        val json = """{"latitude": "52.986375","name": "Christina McArdle","longitude": "-6.043701"}"""
        val customer = JsonCustomer.fromString(json)
        assert(customer.isEmpty)
      }

      it("should not convert invalid record, missing name") {
        val json = """{"latitude": "52.986375","user_id": 12,"longitude": "-6.043701"}"""
        val customer = JsonCustomer.fromString(json)
        assert(customer.isEmpty)
      }

      it("should not convert invalid record, missing latitude") {
        val json = """{"user_id": 12,"name": "Christina McArdle","longitude": "-6.043701"}"""
        val customer = JsonCustomer.fromString(json)
        assert(customer.isEmpty)
      }

      it("should not convert invalid record, missing longitude") {
        val json = """{"latitude": "52.986375","user_id": 12,"name": "Christina McArdle"}"""
        val customer = JsonCustomer.fromString(json)
        assert(customer.isEmpty)
      }
    }
  }

}