package ProjectName.modelUtil

import org.apache.spark.ml.regression.{LinearRegression, LinearRegressionModel}
import org.apache.spark.sql.DataFrame

object EcommerceLinearRegression {

  def trainLinearRegression(df: DataFrame): LinearRegressionModel = {

    val lr = new LinearRegression().setMaxIter(100).setRegParam(0.0).setElasticNetParam(0.0).setStandardization(true)
    val lrModel = lr.fit(df)

    return lrModel

  }

}

