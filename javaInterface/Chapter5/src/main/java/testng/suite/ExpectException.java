package testng.suite;

import org.testng.annotations.Test;

public class ExpectException {

    //该用例希望代码抛出RuntimeException异常，但是代码不会抛出这个异常，
    // 所以这个用例在测试的时候是未通过的
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFail(){
        System.out.println("失败的异常测试");
    }

    //该用例希望代码抛出RuntimeException异常，代码一定抛出这个异常，
    // 所以这个用例在测试的时候是通过的
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("异常测试");
        throw new RuntimeException();
    }
}
