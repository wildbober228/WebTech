package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DataHelper;

import static org.junit.Assert.assertEquals;

public class StepDefinitionsStringToInt {

    private String _actualAnswer;
    private int actualAnswerInt;

    @Given("^variable with type String (\\d+)$")
    public void type_is_String(String arg1) {
        _actualAnswer = arg1;
    }

    @Given("variable with type String (\\D+)$")
    public void variableWithTypeStringAsdad(String arg1) {
        _actualAnswer = arg1;
    }

    @When("parse this variable to type Int")
    public void convert_String_to_Int() {
        actualAnswerInt = DataHelper.ParseToInt(_actualAnswer);
    }

    @Then("variable with type Int (\\d+)$")
    public void type_is_Int(int expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswerInt);
    }

    @Then("variable with type Int (\\-1)$")
    public void type_is_Int_Error(int expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswerInt);
    }

}
