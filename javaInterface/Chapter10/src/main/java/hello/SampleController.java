package hello;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class,args);
    }
}
