package testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforSuite(){
        System.out.println("befor Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after Suite");

    }

   @BeforeTest
    public void beforTest(){
        System.out.println("beforTest");
   }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
}
