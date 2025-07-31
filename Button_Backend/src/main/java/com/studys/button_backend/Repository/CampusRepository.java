package com.studys.button_backend.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CampusRepository {

    private final JdbcTemplate jdbcTemplate;

    public CampusRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public Boolean register(String className){
        String sql = "insert into campus(name) values(?)";

        try{
            jdbcTemplate.update(sql, className);
            return true;
        }
        catch(Exception e){return false;}
    }

    public Boolean deleteCampus(int id){
        String sql = "delete from campus where id = ?";

        return jdbcTemplate.update(sql, id) != 0;


    }
}
