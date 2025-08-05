package com.studys.button_backend.Interface;

public interface CampusInterface {

    public Boolean registerCampus(String name, String token);

    public Boolean deleteCampus(int id_campus, String token);
}
