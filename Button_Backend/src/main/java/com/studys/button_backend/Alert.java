package com.studys.button_backend;

import javax.xml.crypto.Data;

public class Alert {
    private int id;
    private String local;
    private String typeAlert;


    public Alert(int id,  String local, String typeAlert) {
        this.id = id;
        this.local = local;
        this.typeAlert = typeAlert;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setTypeAlert(String typeAlert) {
        this.typeAlert = typeAlert;
    }

    public int getId() {return id;}
    public String getLocal() {return local;}
    public String getTypeAlert() {return typeAlert;}
}

