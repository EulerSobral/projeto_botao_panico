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
        String checkExistsCampusSQL = "SELECT COUNT(*) FROM campus WHERE id = ?";
        Integer countCampus = jdbcTemplate.queryForObject(checkExistsCampusSQL, Integer.class, id_campus);

        if (countCampus == 0 || countCampus == null) {
            return false;
        }

        String sql = "insert into buttons(class, id_campus) values(?, ?)";

        try{
            jdbcTemplate.update(sql, className, id_campus);
            return true;
        }
        catch(Exception e){return false;}
    }

    public Boolean delete(int id){
        String sql = "delete from buttons where id = ?";

        return jdbcTemplate.update(sql, id) != 0;
    }


}
