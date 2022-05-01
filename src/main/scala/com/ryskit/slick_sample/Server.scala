package com.ryskit.slick_sample

import slick.jdbc.JdbcBackend.Database
import slick.jdbc.PostgresProfile.api._

import java.sql.Timestamp
import java.time.Instant
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with demo.Tables

object Server extends App {
  val db = Database.forConfig("pg_database")
  val uuid = java.util.UUID.randomUUID()
  val users: TableQuery[Tables.Users] = Tables.Users
  val insertUser = users +=
    Tables.UsersRow(
      java.util.UUID.randomUUID().toString,
      Timestamp.from(Instant.now())
    )

  val f = db.run(insertUser)
  Await.result(f, Duration.Inf)
}
