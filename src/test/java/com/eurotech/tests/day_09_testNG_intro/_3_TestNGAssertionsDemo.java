package com.eurotech.tests.day_09_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _3_TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp() {
        System.out.println("** Open Browser **");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("** Close Browser **");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("Title","Title");



        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test(priority = 3)
    public void test2() {
        System.out.println("Third Assertion");
        Assert.assertEquals("test2","test2");
      //  int i=8/0;
    }

    @Test (priority = 4)
    public void test3() {
        String expectedTitle="Euro";
        String actualTitle="Eurotech";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify that title starting Euro");

    }

    @Test(priority = 6)
    public void test4() {
        //verify that email contains "@" sign
        String email="eurotech@study.com";

//        if(email.contains("@")){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAIL");
//        }

        Assert.assertTrue(email.contains("@"),"verfiy that email contains @ and .com");
        Assert.assertTrue(email.contains("@")&&email.contains("com"),"verfiy that email contains @ and .com");
    }

    @Test(priority = 2)
    public void test5() {
        Assert.assertFalse(0>1,"verify that 0 is NOT greater than 1");
    }

    @Test(priority = 5)
    public void test6() {
        Assert.assertNotEquals("two","one");

    }

    @Test(priority = 7)
    public void test7() {
        String str="Ahmet";
        Assert.assertNotNull(str,"verify that object has a value");

        String str1=null;
        Assert.assertNull(str1,"verify that object has null value");

    }


}
