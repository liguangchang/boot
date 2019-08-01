package com.jasmine.boot.pojo;

/**
 * thymeleaf 迭代遍历测试
 * @author guangchang
 **/

public class Test {
    private String name;
    private Integer age;

    public Test() {
    }

    public Test(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
