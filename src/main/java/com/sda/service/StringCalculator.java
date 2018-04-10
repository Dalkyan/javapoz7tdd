package com.sda.service;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    public int calculate(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }
        String[] split = text.split(";");
        int result = 0;
//        for (String s : split){}
        for (int i = 0; i < split.length; i++) {
            result += Integer.valueOf(StringUtils.deleteWhitespace(split[i]));
        }
        return result;
    }
}
