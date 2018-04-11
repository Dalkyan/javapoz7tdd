package com.sda.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class WriterService {
    public String write(String name) {
        return prefix(name) + content(name) + suffix(name);
    }

    private String prefix(String name) {
        return isCapitalizedName(name) ? "HELLO, " : "Hello, ";
    }

    private String content(String name) {
        if (StringUtils.isBlank(name)) {
            return "my friend";
        }
        name = StringUtils.deleteWhitespace(name);
        StringBuilder sb = new StringBuilder();
        String[] names = name.split(",");

        for (int i = 0; i < names.length - 1; i++) {
            sb.append(names[i])
                    .append(getDelimiter(i, names, name));
        }
//        return StringUtils.isBlank(name) ? "my friend" : name;
        return sb.append(names[names.length - 1]).toString();
    }

    private String getDelimiter(int index, String[] names, String name) {
        return index != names.length - 2 ? ", " :
                (isCapitalizedName(name) ? " AND " : " and ");

    }

    private String suffix(String name) {
        return isCapitalizedName(name) ? "!" : ".";
    }

    private boolean isCapitalizedName(String name) {
        return StringUtils.isNotBlank(name) && name.toUpperCase().equals(name);
    }

    public static void main(String[] args) {
        WriterService writerService = new WriterService();
        String write = writerService.write("");


        System.out.println(write);
    }
}
