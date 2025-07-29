package com.studys.button_backend.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String Login(String registration, String password) throws Exception {
        String sql = "select password, type from User where registration = ?";

        try{
            Map<String, Object> userLogin = jdbcTemplate.queryForMap(sql, new Object[]{registration});

            if(userLogin.get("password").toString().equals(password)) return userLogin.get("type").toString();
            return "Error";
        }
        catch(Exception e){throw new Exception("Login Error");}
    }

    public Boolean Register(String registration, String password, String email, String phone){
        String sql = "insert into User(registration, password, email, phone) values(?,?,?,?)";

        try{
            jdbcTemplate.update(sql, new Object[]{registration, password, email, phone});
            return true;
        }
        catch(Exception e){return false;}
    }

    public Boolean delete(String registration){
        String sql = "delete from User where registration = ?";

        try{
            jdbcTemplate.update(sql, new Object[]{registration});
            return true;
        }
        catch(Exception e){return false;}
    }
}

