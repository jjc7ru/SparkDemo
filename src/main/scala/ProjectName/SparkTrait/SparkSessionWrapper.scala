package ProjectName.SparkTrait

import org.apache.spark.sql.SparkSession

trait SparkSessionWrapper {

  val spark: SparkSession = {
    SparkSession
      .builder()
      .appName("Spark Example")
      .master("local[*]")
      .getOrCreate()
  }

  val reader = spark.read
    .option("header", "true")
    .option("inferSchema", "true")
    .option("mode", "DROPMALFORMED")

  def close = {
    spark.close()
  }

}
