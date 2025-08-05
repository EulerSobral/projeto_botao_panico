package com.studys.button_backend.Service;
import com.studys.button_backend.Interface.AlertInterface;
import com.studys.button_backend.Repository.AlertRepository;
import com.studys.button_backend.Repository.UserRepository;
import com.studys.button_backend.Util.AdapterTypePhysicsButton;
import com.studys.button_backend.Util.JwtUtil;
import com.studys.button_backend.Util.SendMessageFacade;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class AlertService implements AlertInterface {

    private final AlertRepository alertRepository;
    private final SendMessageFacade sendMessageFacade;
    private final AdapterTypePhysicsButton typePhysicsButton;
    private final UserRepository userRepository;

    public AlertService(AlertRepository alertRepository, SendMessageFacade sendMessageFacade,  AdapterTypePhysicsButton typePhysicsButton , UserRepository userRepository) {
        this.alertRepository = alertRepository;
        this.sendMessageFacade = sendMessageFacade;
        this.typePhysicsButton = typePhysicsButton;
        this.userRepository = userRepository;
    }


    public Boolean sendAlert(int id_button){
        ZoneId fusoHorarioBrasil = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime dataHoraAtualNoBrasil = ZonedDateTime.now(fusoHorarioBrasil);

        LocalDate data = dataHoraAtualNoBrasil.toLocalDate();

        System.out.println("Chegou no service");

        String type = typePhysicsButton.getType();

        sendMessageFacade.sendMessages(type);

        return alertRepository.createAlert(id_button, type, data);
    }



    public Boolean sendAlert(String local, String type, String token){
        System.out.println("Chegou no service");

        int id_user = Integer.parseInt(JwtUtil.decodeToken(token).getSubject());

        sendMessageFacade.sendMessages(type);

        ZoneId fusoHorarioBrasil = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime dataHoraAtualNoBrasil = ZonedDateTime.now(fusoHorarioBrasil);

        LocalDate data = dataHoraAtualNoBrasil.toLocalDate();
        return alertRepository.createAlert(id_user, local, type, data);
    }


}
