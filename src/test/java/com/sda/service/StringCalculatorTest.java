package com.sda.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    private StringCalculator calculator;
    @Before
    public void init(){
    this.calculator = new StringCalculator();
    }


    @Test
    public void testSimpleCalcilation(){
//        //given
//        StringCalculator calculator = new StringCalculator();
        //then

        Assert.assertEquals(5, calculator.calculate("2;3"));
        Assert.assertEquals(6, calculator.calculate("1;5"));
        Assert.assertEquals(17, calculator.calculate("8;9"));
        Assert.assertEquals(11, calculator.calculate("6;5"));

    }
    @Test
    public void nullValue(){
        Assert.assertEquals(0, calculator.calculate(null));
    }@Test
    public void blankValue(){
        Assert.assertEquals(0, calculator.calculate(""));
    }


}
