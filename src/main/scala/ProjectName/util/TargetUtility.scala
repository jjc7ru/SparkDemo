package ProjectName.util

import org.apache.spark.sql.functions.udf

object TargetUtility {

  def udfTransformation = udf((target: Integer) => {
    transformation(target)
  })

  def transformation(number: Integer) : String = {

    if (number > 500) {"1"}
    else {"0"}

  }
}
