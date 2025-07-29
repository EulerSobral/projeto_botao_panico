package com.studys.button_backend.Service;


import com.studys.button_backend.Repository.CampusRepository;
import org.springframework.stereotype.Service;

@Service
public class CampusService {

    private final CampusRepository campusRepository;

    public CampusService(CampusRepository campusRepository){this.campusRepository = campusRepository;}

    public void registerCampus(int id, String name){

    }

    public void deleteCampus(int id, String name){

    }


}
