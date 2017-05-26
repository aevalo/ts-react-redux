organization := "io.github.aevalo"
name := "react"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.2"

val Http4sVersion = "0.17.0-M2"

unmanagedResourceDirectories in Compile += baseDirectory.value / "extra-resources"
unmanagedResourceDirectories in Runtime += baseDirectory.value / "extra-resources"

libraryDependencies ++= Seq(
 "org.http4s"     %% "http4s-blaze-server" % Http4sVersion,
 "org.http4s"     %% "http4s-circe"        % Http4sVersion,
 "org.http4s"     %% "http4s-dsl"          % Http4sVersion,
 "ch.qos.logback" %  "logback-classic"     % "1.2.1"
)
