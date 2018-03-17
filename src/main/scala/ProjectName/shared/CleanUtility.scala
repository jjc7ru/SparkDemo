package ProjectName.shared

import ProjectName.util.{TargetUtility, EmailUtility}
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object CleanUtility {

  def cleanEmail(df: DataFrame): DataFrame = {
    df.withColumn("EmailURL", EmailUtility.udfGetEmail(col("Email")))
  }

  def roundTarget(df: DataFrame): DataFrame = {
    df.withColumn("Rounded_Target", round(col("Yearly Amount Spent"), -2))
  }

  def transformTarget(df: DataFrame): DataFrame = {
    df.withColumn("Yearly_Amount_Spent_Target", TargetUtility.udfTransformation(col("Yearly Amount Spent")))
  }


}
