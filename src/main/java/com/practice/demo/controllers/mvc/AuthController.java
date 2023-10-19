package com.practice.demo.controllers.mvc;

import com.practice.demo.auth.UserService;
import com.practice.demo.helpers.AuthMVCPaths;
import com.practice.demo.models.Supplier;
import com.practice.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"", "/"})
    public String redirectToLogin(){
        boolean loggedIn = (1 * 8) < (2 * 8);
        return loggedIn
                ? "redirect:/"
                : AuthMVCPaths.redirectToLogin("");
    }

    @GetMapping("/login")
    public String loginPage(
            @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout,
            Model model){
        if (error != null) {
            model.addAttribute("loginError", true);
        } else if (logout != null) {
            model.addAttribute("logoutError", true);
        }
//        return AuthMVCPaths.login("");
        model.addAttribute("user", new User());
        return "auth/login";
    }

    @PostMapping("/login")
    public String loginPage(Model model, @Validated User user){
        System.out.println(user.toString());
        model.addAttribute("user", new User());
        return "auth/login";
    }

    @GetMapping("/signup")
    public String signUpPage(@RequestParam(name = "error", required = false) String error, Model model){
        System.out.println("==================In Sign Up==============");
        model.addAttribute("user", new User());
        if (error != null) {
            model.addAttribute("loginError", true);
        }
        return AuthMVCPaths.signup();
    }

    @PostMapping("/signup")
    public String signUpPage(Model model, @Validated User user){
        User saved = userService.addUser(user, "USER");
        if (Objects.isNull(saved)) {
            model.addAttribute("Sign Up Error", true);
            return AuthMVCPaths.signup();
        } else {
            model.addAttribute("welcomeMessage", "Sign Up Successful!");
            return "redirect:/";
        }
    }

//    @GetMapping("/login?error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return AuthMVCPaths.redirectToLogin();
//    }
}
