package com.app;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @GetMapping("/")
    public String loginPage() {
        // Return HTML directly
        return """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Login Page</title>
            </head>
            <body>
                <h2>Welcome to Login!</h2>
                <form id="loginForm">
                    <label>Username:</label>
                    <input type="text" name="username" id="username" required><br><br>
                    <label>Password:</label>
                    <input type="password" name="password" id="password" required><br><br>
                    <button type="submit">Login</button>
                </form>

                <p id="result"></p>

                <script>
                    const form = document.getElementById('loginForm');
                    form.addEventListener('submit', async (e) => {
                        e.preventDefault();
                        const username = document.getElementById('username').value;
                        const password = document.getElementById('password').value;

                        const response = await fetch('/login', {
                            method: 'POST',
                            headers: {'Content-Type': 'application/json'},
                            body: JSON.stringify({username, password})
                        });

                        const text = await response.text();
                        document.getElementById('result').innerText = text;
                    });
                </script>
            </body>
            </html>
        """;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if("admin".equals(user.username) && "1234".equals(user.password)) {
            return "Login Success";
        }
        return "Login Failed";
    }

    static class User {
        public String username;
        public String password;
    }
}
