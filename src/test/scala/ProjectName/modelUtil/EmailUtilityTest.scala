package ProjectName.modelUtil

import ProjectName.util.EmailUtility
import org.junit.runner.RunWith
import org.scalatest.{FunSuite, GivenWhenThen}

@RunWith(classOf[org.scalatest.junit.JUnitRunner])
class EmailUtilityTest extends FunSuite with GivenWhenThen {

  test("getEmail extracts addresses from email") {
    Given("an Email string with '.com' appended at the end")
    var input = "test@gmail.com"

    When("getEmail is called")
    var output = EmailUtility.getEmail(input)

    Then("we should get a response of gmail")
    assert(output == "gmail")
  }

}
