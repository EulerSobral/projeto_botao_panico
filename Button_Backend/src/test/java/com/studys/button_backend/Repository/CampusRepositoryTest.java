package com.studys.button_backend.Repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class CampusRepositoryTest {

    @Autowired
    CampusRepository campusRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("register sucess campus in database")
    void registerSucessCampus() {
        String campus = "Campina Grande";
        Boolean result = campusRepository.register(campus);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("not register sucess campus in database")
    void registerNotSucessCampus() {
        String campus = null;
        Boolean result = campusRepository.register(campus);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("delete sucess campus in database")
    void deleteCampusSucess() {
        String campus = "Campina Grande";
        Boolean register = campusRepository.register(campus);

        assertThat(register).isTrue();

        Boolean result = campusRepository.deleteCampus(1);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("not delete sucess campus in database")
    void deleteCampusNotSucess() {
        Boolean result = campusRepository.deleteCampus(2);
        assertThat(result).isFalse();
    }
}