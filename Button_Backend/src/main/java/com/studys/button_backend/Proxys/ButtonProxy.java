package com.studys.button_backend.Proxys;

import com.studys.button_backend.Interface.ButtonInterface;
import com.studys.button_backend.Service.ButtonService;
import com.studys.button_backend.Util.JwtUtil;

public class ButtonProxy implements ButtonInterface {

    private final ButtonService buttonService;

    public ButtonProxy(ButtonService buttonService) {
        this.buttonService = buttonService;
    }

    @Override
    public Boolean registerButton(String classButton, int id_campus, String token) {
        System.out.println("chegou no proxy do botão");
        checkToken(token);
        return buttonService.registerButton(classButton, id_campus);
    }


    @Override
    public Boolean deleteButton(int id_campus, String token){
        System.out.println("chegou no proxy do botão");
        checkToken(token);
        return buttonService.deleteButton(id_campus);
    }

    private void checkToken(String token) {
        try {
            JwtUtil.decodeToken(token);
        } catch (Exception e) {
            throw new RuntimeException("Token inválido ou expirado");
        }
    }
}
