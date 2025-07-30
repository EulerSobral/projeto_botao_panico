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

    private AlertService alertService;

    public AlertProxy(AlertService alertService){
        this.alertService = alertService;
    }

    public Boolean sendAlert(int id_button, String type, LocalDate data){

        return alertService.sendAlert(id_button, type, data);
    }


    public Boolean sendAlert(String local, String type, LocalDate data, String token){
        String tokenAdjusted;
        tokenAdjusted = token.substring(7);
        checkToken(tokenAdjusted);
        return alertService.sendAlert(local, type, data, tokenAdjusted);
    }

    private void checkToken(String token) {
        try {
            JwtUtil.decodeToken(token);
        } catch (Exception e) {
            throw new RuntimeException("Token inválido ou expirado");
        }
    }
}
