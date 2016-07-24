package com.stuartizon.umbrella.sbt

import scalaj.http._

object UmbrellaClient {
  def postCoverage(name: String, version: String, report: String): String = {
    Http("http://api.umbrella.ovotech.org.uk/cobertura")
      .header("Content-Type", "application/xml")
      .header("Project-Name", name)
      .header("Project-Version", version)
      .postData(report)
      .asString
      .body
  }
}