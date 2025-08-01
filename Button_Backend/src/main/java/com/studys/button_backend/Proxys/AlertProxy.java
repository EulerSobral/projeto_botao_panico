package com.studys.button_backend.Proxys;

import com.studys.button_backend.Interface.AlertInterface;
import com.studys.button_backend.Repository.AlertRepository;
import com.studys.button_backend.Service.AlertService;
import com.studys.button_backend.Util.JwtUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Primary
@Service
public class AlertProxy implements AlertInterface {

    private final AlertService alertService;

    public AlertProxy(AlertService alertService){
        this.alertService = alertService;
    }

    @Override
    public Boolean sendAlert(int id_button, String type){
        System.out.println("chegou no proxy");
        return alertService.sendAlert(id_button, type);
    }

    @Override
    public Boolean sendAlert(String local, String type,  String token){
        System.out.println("Chegou no proxy");
        checkToken(token);
        System.out.println(token);
        return alertService.sendAlert(local, type,  token);
    }

    private void checkToken(String token) {
        try {
            JwtUtil.decodeToken(token);
        } catch (Exception e) {
            System.out.println("Token invalido");
            throw new RuntimeException("Token inválido ou expirado");
        }
    }
}
