package Log4j;
import org.apache.log4j.Logger;
public class Test {
    final Logger log=Logger.getLogger(Test.class);
    public void test(){
        log.info("this is log");
    }
}
