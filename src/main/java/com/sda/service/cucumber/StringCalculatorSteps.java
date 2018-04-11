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
    public void i_initialize_stringCalculator(){
        this.calculator = new StringCalculator();}

    @And("^I pass single number value$")
    public void i_pass_single_number_value() {
        this.value = "5";
    }

    @When("^I trigger calculate function$")
    public void i_trigger_calculate_function() {
        this.result = calculator.calculate(value);
    }

    @Then("^I get 5 as a result$")
    public void I_get_5_as_a_result() {
        Assert.assertEquals(5, result);
    }

    @And("^I pass null value$")
    public void i_pass_null_value(){
        this.value = null;
    }

    @Then("^I get 0 as a result$")
    public void i_get_0_as_a_result(){
    Assert.assertEquals(0,result);}

    @And("^I pass empty string$")
    public void i_pass_empty_string(){
        this.value = "";}

    @And("^I pass multiple numbers$")
    public void i_pass_multiple_numbers(){
        this.value ="1;1;8";
    }

    @Then("^I get 10 as a result$")
    public void i_get_10_as_a_result(){
        Assert.assertEquals(10, result);
    }

    @And("^I pass multiple numbers with whitespaces$")
    public void i_pass_multiple_numbers_with_whitespaces(){
        this.value = "      7;   2  ; 1";
    }

    @And("^I pass two numbers$")
    public void i_pass_two_numbers(){
        this.value = "10;0";
    }
}
