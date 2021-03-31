package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DataHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class StepDefinitionsStringToDate {

    private String _actualAnswer;
    private Date actualAnswerDate;

    @Given("variables with type String {int}-{int}-{int}")
    public void variables_with_type_string(Integer int1, Integer int2, Integer int3) {
        _actualAnswer = int1+ "-" + int2 + "-" + int3;
    }

    @When("parse this variable to type Date")
    public void parse_this_variable_to_type_date() throws ParseException {

        actualAnswerDate = DataHelper.StringToDate(_actualAnswer);
    }

    @Then("variable with type Float {int}-{int}-{int}")
    public void variable_with_type_float(Integer int1, Integer int2, Integer int3) throws ParseException {
        String date = int1+ "-" + int2 + "-" + int3;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedAnswer  = format.parse(date);
        assertEquals(expectedAnswer, actualAnswerDate);
    }

    @Given("variable with type String 202djd")
    public void variable_with_type_string_202djd() {
        _actualAnswer = "202djd";
    }

    @Then("variable with type Date null")
    public void variable_with_type_date() {
        assertEquals(null, actualAnswerDate);
    }


}
