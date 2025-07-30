package com.studys.button_backend.Service;
import com.studys.button_backend.DTO.RegisterBody;
import com.studys.button_backend.Interface.AlertInterface;
import com.studys.button_backend.Repository.AlertRepository;
import com.studys.button_backend.Repository.CampusRepository;
import com.studys.button_backend.Util.JwtUtil;
import org.springframework.stereotype.Service;
import com.studys.button_backend.SendMessageFacade;

import java.time.LocalDate;
import java.util.List;

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
        List<RegisterBody> users = List.of();
        for (RegisterBody user : users) {
            if (user.getEmail() != null && !user.getEmail().isEmpty()) {
                SendMessageFacade.sendMessages(user.getEmail());
            } else {
                System.out.println("Usuário " + user.getRegistration() + " não possui e-mail válido. Ignorando.");
            }
        }
        int id_user = Integer.parseInt(JwtUtil.decodeToken(token).getSubject());
        return alertRepository.createAlert(id_user, local, type, data);
    }
}
