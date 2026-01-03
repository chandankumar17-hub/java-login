package com.app;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @GetMapping("/")
    public String loginPage() {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>Welcome to Shopping</title>" +
                "<style>" +
                "body { " +
                "font-family: Arial, sans-serif; " +
                "background-image: url('https://images.unsplash.com/photo-1556740749-887f6717d7e4?auto=format&fit=crop&w=1350&q=80'); " +
                "background-size: cover; " +
                "background-position: center; " +
                "text-align: center; " +
                "padding-top: 50px;" +
                "color: #fff;" +
                "}" +
                "h1 { color: #ffcc00; margin-bottom: 40px; text-shadow: 2px 2px 4px #000;}" +
                "form { background: rgba(255,255,255,0.9); padding: 30px; display: inline-block; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.3); color: #000;}" +
                "input { display: block; margin: 10px auto; padding: 10px; width: 220px; border-radius: 6px; border: 1px solid #ccc; }" +
                "input[type='submit'] { background-color: #ff6600; color: white; border: none; cursor: pointer; font-weight: bold; }" +
                "input[type='submit']:hover { background-color: #e65c00; }" +
                ".footer { margin-top: 20px; font-size: 12px; color: #fff; text-shadow: 1px 1px 2px #000; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<h1>Welcome to Shopping!</h1>" +
                "<form method='post' action='/login'>" +
                "Username: <input name='username' placeholder='Enter username'/><br/>" +
                "Password: <input name='password' type='password' placeholder='Enter password'/><br/>" +
                "<input type='submit' value='Login'/>" +
                "</form>" +
                "<div class='footer'>Mini Shopping Page Demo</div>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "1234".equals(password)) {
            return "<h2 style='color:green;text-align:center;'>✅ Login Success! Welcome to Shopping.</h2>";
        }
        return "<h2 style='color:red;text-align:center;'>❌ Login Failed! Try Again.</h2>";
    }
}
