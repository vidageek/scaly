organization := "net.vidageek"

name         := "scaly"

version in Global := "0.1"

scalaVersion := "2.10.3"


libraryDependencies ++= Seq("junit" % "junit" % "4.10", 
							"org.specs2" % "specs2_2.10" % "2.2",
							"br.com.caelum" % "vraptor" % "3.5.3",
							"log4j" % "log4j" % "1.2.16",
							"org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "container",
      						"org.eclipse.jetty" % "jetty-servlets" % "7.4.5.v20110725" % "container",
      						"org.eclipse.jetty" % "jetty-jsp-2.1" % "7.4.5.v20110725" % "container",
      						"org.mortbay.jetty" % "jsp-2.1-glassfish" % "2.1.v20100127" % "container",
      						"javax.servlet" % "servlet-api" % "2.5" % "container",
      						"javax.enterprise" % "cdi-api" % "1.1" % "provided"
							)

EclipseKeys.withSource := true

seq(webSettings :_*)

ivyXML := <dependency org="org.eclipse.jetty.orbit" name="javax.servlet" rev="3.0.0.v201112011016"><artifact name="javax.servlet" type="orbit" ext="jar"/></dependency>

classDirectory in Compile <<= baseDirectory apply ( _ / "src" / "main" / "webapp" / "WEB-INF" / "classes")

javacOptions += "-g"

scalacOptions += "-language:_"