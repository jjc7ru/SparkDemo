package ProjectName.modelUtil

import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col

object DataMapper {

  def formatData(df: DataFrame): DataFrame = {

    val assembler = new VectorAssembler()
      .setInputCols(Array("Avg Session Length", "Time on App", "Time on Website", "Length of Membership"))
      .setOutputCol("features")

    val output = assembler.transform(df).select(col("label"), col("features"))

    val allData = output.select("label", "features")

    return allData
  }
}
