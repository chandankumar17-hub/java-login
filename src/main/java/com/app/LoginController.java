package com.app;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if ("admin".equals(user.username) && "1234".equals(user.password)) {
            return "Login Success";
        }
        return "Login Failed";
    }

    static class User {
        public String username;
        public String password;
    }
}
