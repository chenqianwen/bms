package cn.future.bms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： ygl
 * @date： 2018/3/16
 * @Description：
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
