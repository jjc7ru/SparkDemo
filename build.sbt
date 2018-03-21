name := "SparkDemoMainV2"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= {
  Seq(
    "org.apache.spark" %% "spark-core" % "2.2.0",
    "org.apache.spark" %% "spark-sql" % "2.2.0",
    "org.apache.spark" %% "spark-mllib" % "2.2.0",
    "org.scalatest" %% "scalatest" % "3.0.4",
    "com.novocode" % "junit-interface" % "0.11" % "test"
  )
}

enablePlugins(DockerPlugin)
enablePlugins(JavaServerAppPackaging)
