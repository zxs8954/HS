package testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test//@Test表示为测试的一部分
    public void testCase1(){
        System.out.println("ceshi1");
    }
    @Test//@Test表示为测试的一部分
    public void testCase2(){
        System.out.println("ceshi2");
    }
    @BeforeMethod//在每一个测试用例前运行
    public void beforeMethord(){
        System.out.println("beforeMethord");
    }
    @AfterMethod//在每一个测试用例后运行
    public void afterMethod(){
        System.out.println("afterMethod");
    }
    @BeforeClass//在每一个类前执行
    public void beforClass(){
        System.out.println("beforeClass");
    }
    @AfterClass//在每一个类后执行
    public void AfterClass(){
        System.out.println("afterClass");
    }
    @BeforeSuite//在所有类运行之前
    public void beforSuite(){
        System.out.println("BeforeSuite");

    }
    @AfterSuite//在所有类运行之后
    public void afterSuite(){
        System.out.println("AfterSuite");

    }



}
