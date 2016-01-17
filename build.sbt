name := "akka-goat-mail"

version := "1.0"

scalaVersion := "2.11.7"

lazy val akkaVersion = "2.4.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
)
