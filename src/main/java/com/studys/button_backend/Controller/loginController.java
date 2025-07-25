package com.studys.button_backend.Controller;

import com.studys.button_backend.Util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/login")
@RestController
public class loginController {

    @GetMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> body){
        try {
            int registration = Integer.parseInt(body.get("registration"));
            String password = body.get("password");

            // Simulação de autenticação simples
            if (registration == 1234567 && "senha123".equals(password)) {
                String tipo = "admin"; // ou "common", dependendo da lógica
                String token = JwtUtil.gerarToken(registration, tipo);

                // Retorna o token no corpo (padrão em APIs REST)
                Map<String, String> resposta = new HashMap<>();
                resposta.put("token", token);
                return ResponseEntity.ok(resposta);
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao processar login");
        }
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Map<String, String> cadastroBody){
        return ResponseEntity.status(200).body("fake");
    }
}
