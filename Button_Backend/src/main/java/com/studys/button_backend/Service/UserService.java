package com.studys.button_backend.Service;


import com.studys.button_backend.Interface.UserInterface;
import com.studys.button_backend.Repository.UserRepository;
import com.studys.button_backend.Util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService implements UserInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Map<String, String> loginUser(int registration) throws Exception {
        try{
            return userRepository.login(registration);
        }
        catch(Exception e){throw new Exception("Error");}
    }

    public Boolean registerUser(String email, String registration, String phone, String password){
        return userRepository.Register(registration, password, email, phone);
    }

    public Boolean deleteUser(String registration){

        return userRepository.delete(registration);
    }


}
