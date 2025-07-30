package com.studys.button_backend.Service;
import com.studys.button_backend.Repository.AlertRepository;
import com.studys.button_backend.Repository.CampusRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository){
        this.alertRepository = alertRepository;
    }

    public Boolean sendAlert(int id_button, String type, LocalDate data){
        return alertRepository.createAlert(id_button, type, data);
    }


    public Boolean sendAlert(String local, String type, LocalDate data, int id_user){
        return alertRepository.createAlert(id_user, local, type, data);
    }
}
