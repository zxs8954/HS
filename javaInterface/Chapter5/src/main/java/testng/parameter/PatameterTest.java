package testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PatameterTest {
    @Test
    @Parameters({"name","age"})
    public void parameterTest1(String name,String age){
        System.out.println("name:"+name+"  age:" + age);
    }
}
