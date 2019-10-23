package com.test;

/*
* Ide 快捷键
* ALT+  enter
* alt+insert
*
 */

import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

public class Person implements Swin{
    private  String name;
    private  int age;
    private String sex;

    public Person() {
        super();
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void fly() {
    }

}
