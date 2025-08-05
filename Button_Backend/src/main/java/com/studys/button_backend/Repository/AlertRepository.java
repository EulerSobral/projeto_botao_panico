package com.studys.button_backend.Repository;

import com.studys.button_backend.Util.SendMessageFacade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public class AlertRepository {

    private final JdbcTemplate jdbcTemplate;

    public AlertRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean createAlert(int id_button, String type, LocalDate data){

        String sql = "insert into alerts(id_button, type, date) values(?,?,?)";


        try{
            jdbcTemplate.update(sql, id_button, type, data);
            return true;
        }
        catch(Exception e){return false;}
    }

    public Boolean createAlert(int id_user, String local, String type, LocalDate data){
        String sql = "insert into alerts(id_user, local, type, date) values(?,?,?,?)";

        try{
            jdbcTemplate.update(sql, id_user, local, type, data);
            return true;
        }
        catch(Exception e){System.out.println(e.getMessage());return false;}
    }
}
