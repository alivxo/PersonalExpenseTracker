package com.expense.tracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.tracker.Models.User;
import com.expense.tracker.Service.UserService;
import com.expense.tracker.util.JwtUtil;
import com.expense.tracker.util.ResponseHandler;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        System.out.println("Encoded Password: " + savedUser.getPassword());

        return ResponseHandler.generateResponse(HttpStatus.OK, "User Registered Successfully", user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        System.out.println("Login attempt for username: " + user.getUsername());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseHandler.generateResponse(HttpStatus.OK, "Successfully logged!!!", token);
    }

    @GetMapping("/validate")
    public ResponseEntity<Object> validateToken(@RequestParam String token) {
        String username = jwtUtil.extractUsername(token);

        if (jwtUtil.validateToken(token, username)) {
            return ResponseHandler.generateResponse(HttpStatus.OK, "Token is valid", null);
        }

        return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, "Token is either invalid or expired", null);
    }
}