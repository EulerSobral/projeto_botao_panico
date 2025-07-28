package com.studys.button_backend.Services;

public class UserDB {

    private int id;
    private String email;
    private String registration;
    private String phone;

    public UserDB(int id,  String email, String registration, String phone) {
        this.id = id;
        this.email = email;
        this.registration = registration;
        this.phone = phone;
    }

    public void setId(int id){this.id=id;}
    public void setEmail(String email){this.email=email;}
    public void setRegistration(String registration){this.registration=registration;}
    public void setPhone(String phone){this.phone=phone;}

    public int getId() {return id;}
    public String getEmail() {return email;}
    public String getRegistration() {return registration;}
    public String getPhone() {return phone;}

}
