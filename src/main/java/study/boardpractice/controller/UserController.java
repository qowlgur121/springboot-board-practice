package study.boardpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import study.boardpractice.domain.Board;
import study.boardpractice.domain.User;
import study.boardpractice.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/create")
    public String creatUser() {

        return "usercreate";
    }
    @PostMapping("/user/createpro")
    public String creatUser(User user) {

        userService.creatUser(user);
        return "index";
    }

    @GetMapping("/user/login")
    public String login() {

        return "login";
    }

    @PostMapping("/user/loginpro")
    public String loginpro(User user, Model model) {

        User findUser = userService.login(user);

        if (findUser != null) {
            String message = findUser.getNickname() + "님! 로그인 되었습니다!";
            model.addAttribute("message", message);
            model.addAttribute("url", "/board/list");
            System.out.println(findUser.getNickname());
        } else {
            model.addAttribute("message", "로그인 실패!");
            model.addAttribute("url", "/user/login");
        }

        return "message";
    }

}
