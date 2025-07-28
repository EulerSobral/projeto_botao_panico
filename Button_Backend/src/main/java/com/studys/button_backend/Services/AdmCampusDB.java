package com.studys.button_backend.Services;

public class AdmCampusDB {

    public int idUser;
    public int idCampus;

    public AdmCampusDB(int idUser, int idCampus){
        this.idUser = idUser;
        this.idCampus = idCampus;
    }

    public void setIdUser(int idUser){this.idUser = idUser;}
    public void setIdCampus(int idCampus){this.idCampus = idCampus;}

    public int getIdUser(){return this.idUser;}
    public int getIdCampus(){return this.idCampus;}
}
