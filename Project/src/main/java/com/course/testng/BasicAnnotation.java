package com.course.testng;
import org.testng.annotations.*;

public class BasicAnnotation {
    // 最基本注解，用来把方法标记为测试一部分
    @Test
    public void testCase1(){
        System.out.println("这是用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("测试用例2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("方法之前");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("方法之后");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("类之前运行");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("类之后运行");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("套件之前运行");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("套件运行之后");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("test 之前");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("test 之后");
    }
}
