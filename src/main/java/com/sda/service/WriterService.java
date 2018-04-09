package com.sda.service;

import org.apache.commons.lang3.StringUtils;

public class WriterService {
    public String write(String name) {
//     return (StringUtils.isBlank(name))?"Hello, my friend." :
//             (name.toUpperCase().equals(name)) ? "HELLO, " + name + "!" : "Hello, " + name + ".";
        String resultString;
        String and = " and";
        if (StringUtils.isBlank(name))
            resultString = "Hello, my friend.";
        else if (name.toUpperCase().equals(name)) {
            resultString = "HELLO, " + name + "!";
            and = " AND";
        } else {
            resultString = "Hello, " + name + ".";
        }
        if (StringUtils.contains(name, ", ")) {
            resultString = resultString.substring(0, resultString.lastIndexOf(",")) + and + resultString.substring(resultString.lastIndexOf(",") + 1);
        }
        return resultString;
    }
}