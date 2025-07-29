package com.studys.button_backend.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CampusRepository {

    private final JdbcTemplate jdbcTemplate;

    public CampusRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public Boolean register(String name){
        String sql = "insert into Campus(name) values(?)";

        try{
            jdbcTemplate.update(sql, name);
            return true;
        }
        catch(Exception e){return false;}
    }

    public Boolean deleteCampus(int id){
        String sql = "delete from Campus where id = ?";

        try{
            jdbcTemplate.update(sql, id);
            return true;
        }
        catch(Exception e){return false;}
    }
}
