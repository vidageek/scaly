name := "Scaly Vraptor Extension" 

version := "1.0"

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= Seq(
	"br.com.caelum" % "vraptor" % "3.4.0" exclude("org.springframework", "spring-core"),
	"com.google.inject" % "guice" % "3.0-rc2",
    "com.google.inject.extensions" % "guice-multibindings" % "3.0-rc2",
    "org.specs2" %% "specs2" % "1.12.1" % "test"
)

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"