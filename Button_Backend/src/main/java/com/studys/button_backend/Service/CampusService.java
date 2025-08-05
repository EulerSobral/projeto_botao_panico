package com.studys.button_backend.Service;


import com.studys.button_backend.Interface.CampusInterface;
import com.studys.button_backend.Repository.CampusRepository;
import org.springframework.stereotype.Service;

@Service
public class CampusService /*implements CampusInterface*/ {

    private final CampusRepository campusRepository;

    public CampusService(CampusRepository campusRepository){
        this.campusRepository = campusRepository;
    }

    public Boolean registerCampus(String name){
        return campusRepository.register(name);
    }

    public Boolean deleteCampus(int id_campus){
        return campusRepository.deleteCampus(id_campus);
    }


}
