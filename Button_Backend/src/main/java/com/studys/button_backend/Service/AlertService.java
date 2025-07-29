package com.studys.button_backend.Service;
import com.studys.button_backend.Repository.AlertRepository;
import com.studys.button_backend.Repository.CampusRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository){this.alertRepository = alertRepository;}

    public void sendAlert(int id, int id_button, String local, String type, LocalDate data){}
}
