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
    }@Test
    public void singleValue(){
        Assert.assertEquals(5, calculator.calculate("5"));
    }
    @Test
    public void manyValues(){
        Assert.assertEquals(6,calculator.calculate("1;2;3"));
        Assert.assertEquals(9,calculator.calculate("4;2;3"));
    }@Test
    public void manyValuesWithWhitepsaces(){
        Assert.assertEquals(6,calculator.calculate("1; 2 ;3"));
        Assert.assertEquals(9,calculator.calculate("4; 2;  3"));
    }

}
