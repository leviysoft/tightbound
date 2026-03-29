ThisBuild / organization := "io.github.leviysoft"
ThisBuild / scalaVersion := "3.3.7"

ThisBuild / licenses := List("MIT" -> url("https://opensource.org/licenses/MIT"))
ThisBuild / homepage := Some(url("https://github.com/leviysoft/tightbound"))
ThisBuild / developers := List(
  Developer(
    id    = "zkerriga",
    name  = "zkerriga",
    email = "zkerriga@gmail.com",
    url   = url("https://github.com/zkerriga"),
  ),
  Developer(
    id    = "leviysoft",
    name  = "leviysoft",
    email = "leviysoft@gmail.com",
    url   = url("https://github.com/leviysoft"),
  ),
)

lazy val root = (project in file("."))
  .settings(
    name := "tightbound",
    libraryDependencies ++= Seq(
      "org.scalatest"      %% "scalatest"     % "3.2.19" % Test,
      "org.apache.commons"  % "commons-math3" % "3.6.1"  % Test,
    ),
  )
