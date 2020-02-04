package com.code.practice.java8.mashup;

public enum EnumSingleton {
	INSTANCE;
	
    int value;

    public int getValue() {

        return value;

    }

    public void setValue(int value) {

        this.value = value;

    }
    
    
    
    @Override
    public String toString() {
    	return super.toString();
    }
}
