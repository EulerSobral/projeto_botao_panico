package com.studys.button_backend.Repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ButtonRepositoryTest {

    @Autowired
    private ButtonRepository buttonRepository;

    @Autowired
    private CampusRepository campusRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("sucess register button")
    void registerSucess() {
        String campusName = "Campina Grande";
        Boolean createCampus = campusRepository.register(campusName);
        assertThat(createCampus).isTrue();
        Boolean result = buttonRepository.register(campusName , 1);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("not sucess register button")
    void registerNotSucess() {
        String campusName = "João Pessoa";
        Boolean result = buttonRepository.register(campusName , 2);

        assertThat(result).isFalse();
    }

   @Test
   @DisplayName("sucess delete register button")
    void deleteSucess() {
        jdbcTemplate.execute("DELETE FROM buttons");
       String campusName = "Campina Grande";
       Boolean createCampus = campusRepository.register(campusName);
       assertThat(createCampus).isTrue();
       Boolean registerButton = buttonRepository.register(campusName , 1);
        assertThat(registerButton).isTrue();
        Boolean result = buttonRepository.delete(1);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("not sucess delete register button")
    void deleteNotSucess() {
       jdbcTemplate.execute("DELETE FROM buttons");
        String campusName = "Campina Grande";
        Boolean createCampus = campusRepository.register(campusName);
        assertThat(createCampus).isTrue();
        Boolean registerButton = buttonRepository.register(campusName , 1);
        assertThat(registerButton).isTrue();
        Boolean result = buttonRepository.delete(2);
        assertThat(result).isFalse();
    }
}