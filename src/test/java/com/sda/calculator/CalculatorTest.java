package com.sda.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void init(){
        this.calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        //when
        int sum = calculator.sum(3, 5);

        //then
        Assert.assertEquals("Wrong result , should have been 8, but it is not.",8,sum);
    }

    @Test
    public void testSubract() {
        //when
        int subtract = calculator.subtract(5,4);
        //then
        Assert.assertEquals("Wrong result , should have been 1, but it is not.",1,subtract);
    }
    @Test
    public void testMultiply() {
        //when
        int multiply = calculator.multiply(5,4);

//then
        Assert.assertEquals("Wrong result , should have been 20, but it is not.",20,multiply);
        Assert.assertEquals("Wrong result , should have been 0, but it is not.",0,calculator.multiply(0,69));
    }
    @Test
    public void testDivide() {
        //when
        int divide = calculator.divide(10,2);
        //thn
        Assert.assertEquals("Wrong result , should have been 5, but it is not.",5,divide);
    }


}
