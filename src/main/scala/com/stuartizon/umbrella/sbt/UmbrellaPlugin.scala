package com.stuartizon.umbrella.sbt

import sbt.Keys._
import sbt.{AutoPlugin, _}

trait UmbrellaKeys {
  lazy val coveragePublish = taskKey[String]("Publishes the coverage report to Umbrella")
}

object UmbrellaPlugin extends AutoPlugin with UmbrellaKeys {
  override def trigger = allRequirements

  object autoImport extends UmbrellaKeys

  override lazy val projectSettings = Seq(
    coveragePublish := {
      val report = IO.read(crossTarget.value / "coverage-report" / "cobertura.xml")
      val response = UmbrellaClient.postCoverage(name.value, version.value, report)
      println(response)
      response
    }
  )
}