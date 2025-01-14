package study.boardpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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



}
