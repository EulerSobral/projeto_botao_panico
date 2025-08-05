package com.studys.button_backend.Controller;

import com.studys.button_backend.Interface.UserInterface;
import com.studys.button_backend.Service.UserService;
import com.studys.button_backend.Util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/login")
public class loginController {

    private final UserInterface userService;

    public loginController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> body){
        try {
            int registration = Integer.parseInt(body.get("registration"));
            String password = body.get("password");

            Map<String, String> mapUser = userService.loginUser(registration);

            if (mapUser.get("password").equals(password)) {
                String type = mapUser.get("type");
                String token = JwtUtil.gerarToken(registration, type);

                Map<String, String> result = new HashMap<>();
                result.put("token", token);
                return ResponseEntity.ok(result);
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao processar login");
        }
    }
}
