package com.studys.button_backend;

import javax.xml.crypto.Data;

public class Alert {
    // id INTEGER auto_increment,
    // id_button INTEGER null,
    // local varchar(250) null,
    // type varchar(25),
    // data datetime
    private int id;
    private GeocalizationAdapter local;
    private String typeAlert;


    public Alert(int id,  GeocalizationAdapter local, String typeAlert) {
        this.id = id;
        this.local = local;
        this.typeAlert = typeAlert;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocal(GeocalizationAdapter local) {
        this.local = local;
    }

    public void setTypeAlert(String typeAlert) {
        this.typeAlert = typeAlert;
    }

    public int getId() {return id;}
    public GeocalizationAdapter getLocal() {return local;}
    public String getTypeAlert() {return typeAlert;}
}

