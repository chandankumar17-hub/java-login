package com.app;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @GetMapping("/")
    public String loginPage() {
        return "<form method='post' action='/login'>" +
               "Username: <input name='username'/><br/>" +
               "Password: <input name='password' type='password'/><br/>" +
               "<input type='submit' value='Login'/></form>";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if("admin".equals(username) && "1234".equals(password)) {
            return "Login Success";
        }
        return "Login Failed";
    }
}
