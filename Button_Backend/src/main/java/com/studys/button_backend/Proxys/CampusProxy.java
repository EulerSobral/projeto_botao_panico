package com.studys.button_backend.Proxys;

import com.studys.button_backend.Interface.CampusInterface;
import com.studys.button_backend.Service.CampusService;
import com.studys.button_backend.Util.JwtUtil;

public class CampusProxy implements CampusInterface {

    private final CampusService campusService;

    public CampusProxy(CampusService campusService) {
        this.campusService = campusService;
    }


    @Override
    public Boolean registerCampus(String name, String token){
        checkToken(token);
        return campusService.registerCampus(name);
    }

    @Override
    public Boolean deleteCampus(int id_campus, String token){
        checkToken(token);
        return campusService.deleteCampus(id_campus);
    }

    private void checkToken(String token) {
        try {
            JwtUtil.decodeToken(token);
        } catch (Exception e) {
            throw new RuntimeException("Token inválido ou expirado");
        }
    }

}
