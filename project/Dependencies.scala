import sbt.{CrossVersion, _}

object Dependencies {
  object Versions {
    val akka = "2.6.19"
    val akkaHttpVersion = "10.2.9"
    val awsSdkV1 = "1.12.167"
    val awsSdkV2 = "2.17.136"

    val circe = "0.15.0-M1"
    val scalaTest = "3.2.11"
    val cats = "2.7.0"
    val testContainers = "0.40.2"
    val guice = "5.1.0"
    val postgres = "42.3.4"
  }

  object Libraries {
    val akkaStream =
      "com.typesafe.akka" %% "akka-stream" % Versions.akka cross CrossVersion.for3Use2_13
    val akkaSl4j =
      "com.typesafe.akka" %% "akka-slf4j" % Versions.akka cross CrossVersion.for3Use2_13
    val akkaHttp =
      "com.typesafe.akka" %% "akka-http" % Versions.akkaHttpVersion cross CrossVersion.for3Use2_13
    val cats =
      "org.typelevel" %% "cats-core" % Versions.cats cross CrossVersion.for3Use2_13
    val akkaHttpSprayJson =
      "com.typesafe.akka" %% "akka-http-spray-json" % Versions.akkaHttpVersion cross CrossVersion.for3Use2_13

    val circeCore =
      "io.circe" %% "circe-core" % Versions.circe cross CrossVersion.for3Use2_13
    val circeParser =
      "io.circe" %% "circe-parser" % Versions.circe cross CrossVersion.for3Use2_13
    val circeGeneric =
      "io.circe" %% "circe-generic" % Versions.circe cross CrossVersion.for3Use2_13
    val circe = Seq(circeCore, circeParser, circeGeneric)

    val mocktito = "org.mockito" % "mockito-core" % "4.5.1" % Test

    val logback = Seq("ch.qos.logback" % "logback-classic" % "1.2.11")
    val slick = "com.typesafe.slick" %% "slick" % "3.3.3"
    val slickCodeGen =
      "com.typesafe.slick" %% "slick-codegen" % "3.3.3"
    val postgres = "org.postgresql" % "postgresql" % Versions.postgres
    val guice = "com.google.inject" % "guice" % Versions.guice
    val shapeless = "com.chuusai" %% "shapeless" % "2.3.9"
  }
}
