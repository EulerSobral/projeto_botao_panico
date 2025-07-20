package com.studys.button_backend.Controller;

import com.studys.button_backend.DTO.LoginBody;
import com.studys.button_backend.DTO.RegisterBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
public class loginController {

    @GetMapping
    public ResponseEntity<String> login(@RequestBody LoginBody loginBody){

        return ResponseEntity.status(200).body("Token");
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegisterBody cadastroBody){
        return ResponseEntity.status(200).body("fake");
    }
}
