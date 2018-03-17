package ProjectName.util

import org.apache.spark.sql.functions.udf

object EmailUtility {

  def udfGetEmail = udf((email: String) => {
    getEmail(email)
  })

  // Get Email URL Only
  def getEmail(str: String): String = {
    str.replaceAll(".+@","").replace(".com","").replace(".net","").replace(".biz","")
  }

}
