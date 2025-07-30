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

    public Map<String, String> loginUser(int registration) throws Exception {

            return userService.loginUser(registration);
    }

    public Boolean registerUser(String email, String registration, String phone, String password){
        return userService.registerUser(registration, password, email, phone);
    }

    public Boolean deleteUser(String token){
        checkToken(token);
        return userService.deleteUser(token);
    }

    private void checkToken(String token) {
        try {
            JwtUtil.decodeToken(token);
        } catch (Exception e) {
            throw new RuntimeException("Token inválido ou expirado");
        }
    }
}
