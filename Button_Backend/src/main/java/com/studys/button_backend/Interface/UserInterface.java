package com.studys.button_backend.Interface;

import java.util.Map;

public interface UserInterface {

    public Map<String, String> loginUser(int registration) throws Exception;

    public Boolean registerUser(String email, String registration, String phone, String password);

    public Boolean deleteUser(String token);
}
