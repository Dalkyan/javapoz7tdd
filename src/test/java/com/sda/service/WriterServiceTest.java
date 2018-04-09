package com.sda.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriterServiceTest {

   private WriterService writerService;

    @Before
    public void init() {
        this.writerService =  new WriterService();
    }
    @Test
    public void testOneName() {

        //given
        String name = "Giedymin";
        //when
        String result = writerService.write(name);
        //then
        Assert.assertEquals("Hello, Giedymin.", result);
    }

    @Test
    public void testNullName(){
        //given
        String name = null;
        //when
        String result = writerService.write(name);
        //then
        Assert.assertEquals("Hello, my friend.", result);
    }
    @Test
    public void testEmptyName(){
        //given
        String name = "";
        //when
        String result = writerService.write(name);
        //then
        Assert.assertEquals("Hello, my friend.", result);
    }

    @Test
    public void testCapitalizeName(){
        //given
        String name = "KLEOFAS";
        //when
        String result = writerService.write(name);
        //then
        Assert.assertEquals("HELLO, KLEOFAS!", result);

    }


}
