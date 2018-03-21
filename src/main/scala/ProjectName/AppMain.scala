package ProjectName

import ProjectName.SparkTrait.SparkSessionWrapper
import ProjectName.modelUtil.{DataMapper, EcommerceLinearRegression, RegressionEvaluationMetric}
import ProjectName.shared.{CleanUtility, FormatUtility}



object AppMain extends SparkSessionWrapper {

  def main(args: Array[String]) = {

    spark.sparkContext.setLogLevel("ERROR")

    println("Reading from csv file")
    val df = reader.csv("Clean-Ecommerce.csv")
    //val df = reader.csv("/Users/jasonchoi/Documents/Data_for_application_testing/SparkDemo/Clean-Ecommerce.csv")
    //val df = reader.csv("C:\\Users\\35928\\Documents\\mySparkDemo\\Data\\Clean-Ecommerce.csv")
    //val df = reader.csv("/home/ubuntu/SampleData/Clean-Ecommerce.csv")

    println("Transforming data")
    val transformingData = df.transform(CleanUtility.cleanEmail)
      .transform(CleanUtility.roundTarget)
      .transform(CleanUtility.transformTarget)

    transformingData.show()


    println("Formatting data")
    val formattingData = transformingData.transform(FormatUtility.columnSelect)

    formattingData.show()


    println("Mapping data")
    val mappingData = DataMapper.formatData(formattingData)

    mappingData.show()


    println("Running Linear Regression")
    val model = EcommerceLinearRegression.trainLinearRegression(mappingData)

    println("Coefficients: " + model.coefficients)
    println("Intercept: " + model.intercept)


    println("Predicting data")
    val dataPredict = model.transform(mappingData)

    dataPredict.show()

    println("Printing out evaluation metrics")
    RegressionEvaluationMetric.metrics(dataPredict)



    close

  }

}
