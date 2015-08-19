package com.github.plippe.steam.intercom.customer

import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.StrictLogging
import java.io.File

import com.github.plippe.steam.intercom.customer.json.JsonCustomer

object Main extends App with StrictLogging {
  val conf = ConfigFactory.load();

  val intercomCoordinate = Coordinate(
    conf.getDouble("intercomOffice.latitude"),
    conf.getDouble("intercomOffice.longitude"))

  val maximumDistance = conf.getDouble("filter.maxDistance")

  val file = {
    val filePath = conf.getString("customerFile")
    new File(getClass.getResource(filePath).toURI)
  }

  val customers = JsonCustomer.fromFile(file)
    .map(JsonCustomer.toCustomer)
    .filter(Customer.distance(_, intercomCoordinate) < maximumDistance)
    .toSeq
    .sortBy(_.id)

  logger.info("The following users should be invited:")
  customers.foreach { c => logger.info(s"${c.name}(${c.id})") }
}
