package testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("test1 On server");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("test2 On server");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("test3 On client");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("test4 On client");
    }
    @BeforeGroups("server")
    public void befroeGroups(){
        System.out.println("befroeGroups");
    }
    @AfterGroups("server")
    public void afterGroups(){
        System.out.println("afterGroups");
    }
}
