package com.fanverse.login_signup_service.controller;

import com.fanverse.login_signup_service.dao.User;
import com.fanverse.login_signup_service.service.JwtService;
import com.fanverse.login_signup_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
//@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/home")
    public String home() {
        return "Hi there user...";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        User savedUser = userService.signup(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUserName(),
                        user.getPassword()
                )
        );
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUserName());
        }
        else {
            return "Invalid username or password!";
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user) {
//        System.out.println(user.toString());
//        Optional<User> loginUser = userService.login(user.getUserName(), user.getPassword());
//        if(loginUser.isPresent()) {
//            return ResponseEntity.ok(loginUser.get());
//        }
//        return ResponseEntity.status(401).body("Invalid Credentials");
//    }

}
