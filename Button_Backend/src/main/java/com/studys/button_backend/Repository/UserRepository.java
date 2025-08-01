package com.studys.button_backend.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, String> login(int registration) throws Exception {
        String sql = "select password, type from users where registration = ?";

        try{
            Map<String, Object> userLogin = jdbcTemplate.queryForMap(sql, new Object[]{registration});

            Map<String, String> result = new HashMap<>();

            result.put("type", userLogin.get("type").toString());
            result.put("password", userLogin.get("password").toString());

            return result;
        }
        catch(Exception e){throw new Exception("Login Error");}
    }

    public Boolean Register(String registration, String password, String email, String phone){
        String sql = "insert into users(registration, password, email, phone) values(?,?,?,?)";

        try{
            jdbcTemplate.update(sql, new Object[]{registration, password, email, phone});
            return true;
        }
        catch(Exception e){return false;}
    }

    public Boolean delete(String registration){
        String sql = "delete from users where registration = ?";

        try{
            jdbcTemplate.update(sql, new Object[]{registration});
            return true;
        }
        catch(Exception e){return false;}
    }
}

