package com.course.testng.paramter;

import org.testng.annotations.*;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("name=" + name + ";" + "age=" + age);
    }
    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] o = new Object[][]{
                {"张雪松",27},
                {"足足",26}
        };
        return o;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1 name="+name+";"+"age="+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2 name="+name+";"+"age="+age);
    }
    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result =null;
        if(method.getName().equals("test1")){
            result=new Object[][]{
                    {"zxs",30},
                    {"lisi",31}
            };
        }else if (method.getName().equals("test2")){
              result=new Object[][]{
                      {"wanger",90}
              }  ;
        }
        return result;
    }
}
