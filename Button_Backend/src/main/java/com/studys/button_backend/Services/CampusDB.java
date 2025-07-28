package com.studys.button_backend.Services;

public class CampusDB {

    public int id;
    public String name;

    public CampusDB(int id,String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}

    public int getId(){return this.id;}
    public String getName(){return this.name;}
}
