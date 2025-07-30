package com.studys.button_backend.DTO;

public class Alert {
<<<<<<< HEAD:Button_Backend/src/main/java/com/studys/button_backend/Alert.java
    private int id;
=======
    // id INTEGER auto_increment,
    // id_button INTEGER null,
    // local varchar(250) null,
    // type varchar(25),
    // data datetime
    private int id_user;
>>>>>>> 557043049a01304431a7a755476e7533dd711771:Button_Backend/src/main/java/com/studys/button_backend/DTO/Alert.java
    private String local;
    private String typeAlert;


    public Alert(int id,  String local, String typeAlert) {
        this.id_user = id;
        this.local = local;
        this.typeAlert = typeAlert;

    }

    public void setId(int id) {
        this.id_user = id;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setTypeAlert(String typeAlert) {
        this.typeAlert = typeAlert;
    }

    public int getId() {return id_user;}
    public String getLocal() {return local;}
    public String getTypeAlert() {return typeAlert;}
}

