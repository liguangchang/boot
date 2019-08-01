package com.jasmine.boot.pojo;

import java.math.BigDecimal;
/**
 *
 * @author guangchang
 **/
public class Person {
    private String name;
    private BigDecimal value;

    public Person(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
