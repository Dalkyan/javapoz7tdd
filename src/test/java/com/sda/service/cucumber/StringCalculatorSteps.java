package com.sda.service.cucumber;

import com.sda.service.StringCalculator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class StringCalculatorSteps {
    private String value;
    private int result;
    private StringCalculator calculator;

    @Given("^I initialize stringCalculator$")
    public void i_initialize_stringCalculator() {
        this.calculator = new StringCalculator();
    }

    @And("^I pass '(.*)' value$")
    public void i_pass_nonnull_value(String value) {
        this.value = value;
    }

    @When("^I trigger calculate function$")
    public void i_trigger_calculate_function() {
        this.result = calculator.calculate(value);
    }

    @Then("^I get (.*) as a result$")
    public void I_get_correct_value_as_a_result(int passedResult) {
        Assert.assertEquals(passedResult, result);
    }

    @And("^I pass null value$")
    public void i_pass_null_value() {
        this.value = null;
    }
}
