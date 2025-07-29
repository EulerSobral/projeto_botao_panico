package com.studys.button_backend.Controller;

import com.studys.button_backend.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> createUser(@RequestBody Map<String,String> user){
        try{
            String email = user.get("email");
            String password = user.get("password");
            String phone = user.get("phone");
            String registration = user.get("registration");

            Boolean result = userService.registerUser(email, registration, phone, password);

            if(result) return ResponseEntity.status(200).body("User registered successfully");
            else return ResponseEntity.status(400).body("User registration failed");
        }
        catch(Exception e){return ResponseEntity.status(400).body("User registration failed");}
    }
}
