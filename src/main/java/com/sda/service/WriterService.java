package com.sda.service;
import org.apache.commons.lang3.StringUtils;
public class WriterService {
    public String write(String name) {
        String resultString;
        if (StringUtils.isBlank(name))
            resultString = "Hello, my friend.";
        else if (name.toUpperCase().equals(name)) {
            resultString = "HELLO, " + name + "!";
        } else resultString = "Hello, " + name + ".";
        return resultString;
    }
}