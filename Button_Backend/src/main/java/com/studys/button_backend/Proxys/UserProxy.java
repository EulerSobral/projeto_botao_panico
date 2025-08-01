package com.studys.button_backend.Proxys;

import com.studys.button_backend.Interface.UserInterface;
import com.studys.button_backend.Repository.UserRepository;
import com.studys.button_backend.Service.UserService;
import com.studys.button_backend.Util.JwtUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;

@Primary
@Service
public class UserProxy implements UserInterface {

    private final UserService userService;

    public UserProxy(UserService userService){
        this.userService = userService;
    }

    @Override
    public Map<String, String> loginUser(int registration) throws Exception {

            return userService.loginUser(registration);
    }

    @Override
    public Boolean registerUser(String email, String registration, String phone, String password){
        return userService.registerUser(email, registration, phone, password);
    }

    @Override
    public Boolean deleteUser(String token) {
        System.out.println("chegou no user proxy");
        checkToken(token);
        String registration = JwtUtil.decodeToken(token).getSubject();
        System.out.println(registration);
        return userService.deleteUser(registration);
    }

    private void checkToken(String token) {
        try {
            JwtUtil.decodeToken(token);
        } catch (Exception e) {
            throw new RuntimeException("Token inválido ou expirado");
        }
    }
}
