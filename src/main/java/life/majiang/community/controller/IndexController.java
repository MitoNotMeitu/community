package life.majiang.community.controller;

import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//controller:我允许这个类去接收前端的一个请求
public class IndexController {

    @Autowired
    private QuestionService questionService;//给这个mapper写方法，用这个方法获取到列表

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,//page代表每一页的页码
                        @RequestParam(name = "size", defaultValue = "5") Integer size,//size代表每页多少内容
                        @RequestParam(name = "search", required = false) String search) {


        PaginationDTO pagination = questionService.list(search,page, size);
        model.addAttribute("pagination", pagination);//把这些东西都装到model里，这样前端可以调用显示
        model.addAttribute("search",search);
        return "index";
    }
}
