package cn.future.bms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/4/6
 * @Description：
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @GetMapping("/list")
    public List<TestModel> list(){

        List<TestModel> list = new ArrayList<>();
        list.add(new TestModelImpl());
        return list;
    }

    interface TestModel{
        String findText();
        String getIcon();
    }

    class TestModelImpl implements TestModel{
        @Override
        public String findText() {
            return "xxxxxxxxx";
        }
        @Override
        public String getIcon() {
            return "yyyyyyyyyy";
        }
    }
}
