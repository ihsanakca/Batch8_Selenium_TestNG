package com.eurotech.tests.day_09_testNG_intro;

import org.testng.annotations.*;

public class _2_BeforeAfterMethod {

    @Test(priority = 2)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    @Ignore
    public void test2() {
        System.out.println("Test 2");
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("Test 3");
    }

    @Test(priority = 1)
    public void test4() {
        System.out.println("Test 4");
    }

    @Test
    public void test5() {
        System.out.println("Test 5");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Before Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }


}
