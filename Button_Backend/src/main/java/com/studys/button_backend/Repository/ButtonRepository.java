package com.studys.button_backend.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ButtonRepository {

    private final JdbcTemplate jdbcTemplate;

    public ButtonRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public Boolean register(String className, int id_campus){
        String sql = "insert into Button(class, id_campus) values(?, ?)";

        try{
            jdbcTemplate.update(sql, className, id_campus);
            return true;
        }
        catch(Exception e){return false;}
    }

    public Boolean delete(int id){
        String sql = "delete from Button where id = ?";

        try{
            jdbcTemplate.update(sql, id);
            return true;
        }
        catch(Exception e){return false;}
    }
}
