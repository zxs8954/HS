package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test3(){
        Assert.assertEquals("11","11");
    }
    @Test
    public void logDemo(){
        Reporter.log("使用Reporter.log（）输出的日志");
        throw  new RuntimeException("主动抛出的RunTimeException");
    }
}
