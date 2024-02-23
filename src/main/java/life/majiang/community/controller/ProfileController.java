package life.majiang.community.controller;

import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;//给这个mapper写方法，用这个方法获取到列表

    @GetMapping("/profile/{action}")//当你试图寻找/profile/{动态名字}的时候，系统自动来这里操作
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,//接收名为action的参数
                          Model model,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,//page代表每一页的页码
                          @RequestParam(name = "size", defaultValue = "5") Integer size) {//size代表每页多少内容)
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }

        PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
        model.addAttribute("pagination", paginationDTO);//把这些东西都装到model里，这样前端可以调用显示
        return "profile";
    }
}
