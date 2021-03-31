package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DataHelper;

import static org.junit.Assert.assertEquals;

public class StepDefinitionsStringToFloat {

    private String _actualAnswer;
    private double actualAnswerFloat;

    @Given("variables with type String {double}")
    public void variables_with_type_string(Double double1) {
        _actualAnswer = String.valueOf(double1);
    }

    @When("parse this variable to type Float")
    public void parse_this_variable_to_type_float() {
        actualAnswerFloat = DataHelper.ParseToFloat(_actualAnswer);
    }

    @Then("variable with type Float {double}")
    public void variable_with_type_float(Double expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswerFloat, 0);
    }



}
