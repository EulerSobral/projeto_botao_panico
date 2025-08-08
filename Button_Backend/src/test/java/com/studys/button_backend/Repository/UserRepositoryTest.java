package com.studys.button_backend.Repository;

import com.studys.button_backend.Controller.UserController;
import com.studys.button_backend.Service.UserService;
import com.zaxxer.hikari.pool.HikariProxyPreparedStatement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    @DisplayName("Sucess user  in database!")
    public void registerSucess( ) {

        String email = "teste@gmail.com";
        String registration = "2025001";
        String phone = "123456789";
        String password = "123456";

        Boolean result = this.userRepository.Register(registration, password,email, phone);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Not Sucess user  in database!")
    public void registerNotSucess( ) {

        String email = "teste@gmail.com";
        String registration = null;
        String phone = "123456789";
        String password = "";

        Boolean result = this.userRepository.Register(registration, password,email, phone);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Sucess user login!")
    void loginSucess() throws Exception {
        Integer registration = 2025001;

        Optional<Map<String, String>> result = Optional.ofNullable(this.userRepository.login(registration));
        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Not sucess user login!")
    void loginNotSucess() throws Exception {
        Integer registration = 2025002;

        Optional<Map<String, String>> result = Optional.ofNullable(this.userRepository.login(registration));
        assertThat(result.isPresent()).isFalse();
    }

   @Test
   @DisplayName("Sucess user delete!")
   void deleteSucess() {
       String email = "teste@gmail.com";
       String registration = "2025001";
       String phone = "123456789";
       String password = "123456";

        this.userRepository.Register(registration, password,email, phone);


       String testeRegistration = "2025001";

       Boolean result = this.userRepository.delete(testeRegistration);
       assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Not sucess user delete!")
    void deleteNotSucess() {
        String email = "teste@gmail.com";
        String registration = "2025001";
        String phone = "123456789";
        String password = "123456";

        String testeRegistration = "2025002";

        this.userRepository.Register(registration, password,email, phone);
        Boolean result = this.userRepository.delete(testeRegistration);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("sucess find email's in databases")
    void findAllEmailsSucess() {
      String email = "teste@gmail.com";
        String registration = "2025001";
        String phone = "123456789";
        String password = "123456";

        Boolean register = this.userRepository.Register(registration, password,email, phone);

        assertThat(register).isTrue();

        List<String> result = this.userRepository.findAllEmails();


        assertThat(result).isNotEmpty();
    }

    @Test
    @DisplayName("not sucess find email's in databases")
    void findAllEmailsNotSucess() {

        jdbcTemplate.execute("DELETE FROM users");
        
        List<String> result = this.userRepository.findAllEmails();

        assertThat(result).isEmpty();
    }
}