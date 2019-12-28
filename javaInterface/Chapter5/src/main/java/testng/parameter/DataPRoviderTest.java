package testng.parameter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
public class DataPRoviderTest {
    //************第一种*********************
    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result=null;
        if(method.getName().equals("test1")){
            result=new Object[][]{
                    {"zhangsan",20},
                    {"lisi",21},
            };
        }else if(method.getName().equals("test2")){
            result=new Object[][]{
                    {"wangwu",30},
                    {"zhaoliu",31},
            };
        }
        return result;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1 name:"+name+";age="+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2 name:"+name+";age="+age);
    }
//**************************第二种*****************************************************
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("");
        System.out.println("name="+name+"  age="+age);
    }
    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o=new Object[][]{
                {"zhangsan",10},
                {"lisi",11},
                {"wangwu",12},
        };
        return o;
    }

}
