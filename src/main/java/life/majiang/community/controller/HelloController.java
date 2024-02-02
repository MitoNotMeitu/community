package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//controller:我允许这个类去接收前端的一个请求
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name="name") String name,Model model){
        model.addAttribute("name",name);
        return "hello";//执行到此就会自动去找hello的模版，位于resources/templates中
    }
}
