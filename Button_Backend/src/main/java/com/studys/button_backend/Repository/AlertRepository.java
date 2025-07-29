package com.studys.button_backend.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class AlertRepository {

    private final JdbcTemplate jdbcTemplate;

    public AlertRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean createButtonAlert(String id_button, String type, LocalDate data){
        String sql = "insert into Alert(id_button, type, data) values(?,?,?)";

        try{
            jdbcTemplate.update(sql, id_button, type, data);
            return true;
        }
        catch(Exception e){return false;}
    }

    public Boolean createPersonalAlert(String id_user, String local, String type, LocalDate data){
        String sql = "insert into Alert(id_user, local, type, data) values(?,?,?,?)";

        try{
            jdbcTemplate.update(sql, id_user, local, type, data);
            return true;
        }
        catch(Exception e){return false;}
    }
}
