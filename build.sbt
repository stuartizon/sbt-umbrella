name := "sbt-umbrella"
version := "1.0.0"
organization := "com.stuartizon"
organizationName := "Stuart Izon"
scalaVersion := "2.10.4"
sbtPlugin := true

libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0"
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
publishMavenStyle := true
publishTo := {
  if (isSnapshot.value)
    Some("Ovotech Nexus Repo Snapshots" at "http://nexus.ovotech.org.uk:8081/nexus/content/repositories/snapshots/")
  else
    Some("Ovotech Nexus Repo Releases" at "http://nexus.ovotech.org.uk:8081/nexus/content/repositories/releases/")
}
pomIncludeRepository := { _ => false }
licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))