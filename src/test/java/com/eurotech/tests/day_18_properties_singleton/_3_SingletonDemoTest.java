package com.eurotech.tests.day_18_properties_singleton;

import org.testng.annotations.Test;

public class _3_SingletonDemoTest {

    @Test
    public void test1(){
//        Because of private constructor, we cannot create an object from the class.
//        _2_SingletonDemo singletonDemo=new _2_SingletonDemo();

        String s = _2_SingletonDemo.getDriver();
        System.out.println("s = " + s);

        String s1 = _2_SingletonDemo.getDriver();
        System.out.println("s1 = " + s1);

        String s2 = _2_SingletonDemo.getDriver();
        System.out.println("s2 = " + s2);
    }
}
