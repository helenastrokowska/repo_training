package zdtestpol51bdd.calculator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalculatorStepsDefinitions {
    //Calculator kalsa - przepis jak powinien wyglądać kalkulator
    //calculator -pole puste stworzone z klasu Calculator

    Calculator calculator; //= new Calculator();
    Integer result;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        //new Calculator() -stwórz nowy obiekt
        // Calculator calculator= new Calculator(); - przeniesione do góry
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        calculator = new Calculator();

    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer int1, Integer int2) {
        result = calculator.addTwoNumbers(int1,int2);
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    @When("I multiply {int} by {int}")
    public void i_multiply_by(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
        result=calculator.multiplyTwoNumbers(int1,int2);

    }

    @When("I subtract {int} from {int}")
    public void i_subtract_from(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        result=calculator.subtract1from2(int1,int2);

    }
    @When("I divide {int} by {int}")
    public void i_divide_by(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        result=calculator.divide1by2(int1,int2);
    }
    @When("I calculate rest from {int} by {int}")
    public void i_calculate_rest_from_by(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        result=calculator.rest(int1,int2);
    }
    @Then("I should get {int}")
    public void ishould_get(Integer int1) {
        Assert.assertEquals(result,int1);

    }
}
