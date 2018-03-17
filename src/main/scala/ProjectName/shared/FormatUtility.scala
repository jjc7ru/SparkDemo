package ProjectName.shared


import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object FormatUtility {

  def columnSelect(df: DataFrame) : DataFrame = {
    df.select(df("Yearly Amount Spent").as("label").cast("Double"),
      col("Avg Session Length"),
      col("Time on App"),
      col("Time on Website"),
      col("Length of Membership"))
  }
}


