package com.flolive.models;

import org.springframework.stereotype.Component;

@Component("fooFormatter")
public class FooFormatter {
    public String format() {
        return "foo";
    }
}