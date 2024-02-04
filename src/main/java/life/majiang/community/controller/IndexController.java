package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//controller:我允许这个类去接收前端的一个请求
public class IndexController {
    @GetMapping("/")
    public String index() { return "index"; }
}
