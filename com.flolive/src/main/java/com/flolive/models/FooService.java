package com.flolive.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooService {  
    
    private FooFormatter fooFormatter;

    @Autowired
    public FooService(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
    
	public FooFormatter getFooFormatter() {
		return fooFormatter;
	}

	public void setFooFormatter(FooFormatter fooFormatter) {
		this.fooFormatter = fooFormatter;
	}
}