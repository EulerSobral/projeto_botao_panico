package com.studys.button_backend.Repository;

import com.studys.button_backend.ButtonBackendApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
class AlertRepositoryTest {
    @Autowired
    AlertRepository alertRepository;

    @Autowired
    CampusRepository campusRepository;

    @Autowired
    ButtonRepository buttonRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Sucess save alert from physics button in database!")
    void createAlertSucessFromButtonPhysics() {
        String campusName = "Campina Grande";
        Boolean createCampus = campusRepository.register(campusName);
        assertThat(createCampus).isTrue();
        Boolean registerButton = buttonRepository.register(campusName , 1);
        assertThat(registerButton).isTrue();

        int id_button = 1;
        String type = "alert";
        ZoneId fusoHorarioBrasil = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime dataHoraAtualNoBrasil = ZonedDateTime.now(fusoHorarioBrasil);

        LocalDate data = dataHoraAtualNoBrasil.toLocalDate();

        Boolean result = alertRepository.createAlert(id_button, type, data);
        assertThat(result).isTrue();

    }

    @Test
    @DisplayName("Not Sucess save alert from physics button in database!")
    void createAlertNotSucessFromButtonPhysics() {

        int id_button = 2;
        String type = "alert";
        ZoneId fusoHorarioBrasil = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime dataHoraAtualNoBrasil = ZonedDateTime.now(fusoHorarioBrasil);

        LocalDate data = dataHoraAtualNoBrasil.toLocalDate();

        Boolean result = alertRepository.createAlert(id_button, type, data);
        assertThat(result).isFalse();

    }

    @Test
    @DisplayName("Sucess save alert from app button in database!")
    void createAlertSucessFromButtonApp() {
        String campusName = "João Pessoa";
        Boolean createCampus = campusRepository.register(campusName);
        assertThat(createCampus).isTrue();

        String email = "teste@gmail.com";
        String registration = "2025001";
        String phone = "123456789";
        String password = "123456";



        Boolean registerUser = this.userRepository.Register(registration, password,email, phone);
        assertThat(registerUser).isTrue();


        String type = "alert";
        ZoneId fusoHorarioBrasil = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime dataHoraAtualNoBrasil = ZonedDateTime.now(fusoHorarioBrasil);

        LocalDate data = dataHoraAtualNoBrasil.toLocalDate();

        Boolean result = alertRepository.createAlert(Integer.parseInt(registration), campusName, type, data);
        assertThat(result).isTrue();

    }


}