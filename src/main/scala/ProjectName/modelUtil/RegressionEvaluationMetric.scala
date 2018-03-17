package ProjectName.modelUtil

import ProjectName.AppMain.spark
import org.apache.spark.mllib.evaluation.RegressionMetrics
import org.apache.spark.sql.DataFrame
import spark.implicits._

object RegressionEvaluationMetric {

  def metrics(df: DataFrame): Unit = {
    val predictionAndLabels = df.select($"prediction", $"label").as[(Double, Double)].rdd
    val metricsOutput = new RegressionMetrics(predictionAndLabels)

    println("MSE: " + metricsOutput.meanSquaredError)
    println("RMSE: " + metricsOutput.rootMeanSquaredError)
    println("R2: " + metricsOutput.r2)
  }

}
