package com.studys.button_backend.Service;
import com.studys.button_backend.Interface.AlertInterface;
import com.studys.button_backend.Repository.AlertRepository;
import com.studys.button_backend.Repository.CampusRepository;
import com.studys.button_backend.Util.JwtUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AlertService implements AlertInterface {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository){
        this.alertRepository = alertRepository;
    }

    public Boolean sendAlert(int id_button, String type, LocalDate data){
        return alertRepository.createAlert(id_button, type, data);
    }


    public Boolean sendAlert(String local, String type, LocalDate data, String token){
        int id_user = Integer.parseInt(JwtUtil.decodeToken(token).getSubject());
        return alertRepository.createAlert(id_user, local, type, data);
    }
}
