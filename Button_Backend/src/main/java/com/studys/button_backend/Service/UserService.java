package com.studys.button_backend.Service;


import com.studys.button_backend.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void loginUser(String registration, String password){}

    public Boolean registerUser(String email, String registration, String phone, String password){
        return userRepository.Register(registration, password, email, phone);
    }

    public Boolean deleteUser(String registration){
        return userRepository.delete(registration);
    }


}
