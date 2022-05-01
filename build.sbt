//import slick.codege.SourceCodeGenerator
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

scalacOptions += "-deprecation"

(Compile / sourceGenerators) += codegen.taskValue

lazy val codegen = taskKey[Seq[File]]("generate slick table code")
codegen := {
  val dir = (Compile / sourceManaged) value
  val outputDir = dir / "slick"
  val url = "jdbc:postgresql://localhost:5432/slick_sample"
  val jdbcDriver = "org.postgresql.Driver"
  val slickDriver = "slick.jdbc.PostgresProfile"
  val pkg = "demo"

  val cp = (Compile / dependencyClasspath) value
  val s = streams value

  runner.value.run("slick.codegen.SourceCodeGenerator",
    cp.files,
    Array(
      slickDriver,
      jdbcDriver,
      url,
      outputDir.getPath,
      pkg,
      "postgres",
      "postgres"
    ),
    s.log
  ).failed foreach (sys error _.getMessage)

  val file = outputDir / pkg / "Tables.scala"
  Seq(file)
}

lazy val root = (project in file("."))
  .settings(
    name := "slick-sample",
    libraryDependencies ++= Seq(
      Dependencies.Libraries.guice,
      Dependencies.Libraries.slickCodeGen,
      Dependencies.Libraries.postgres,
    ),
  )
