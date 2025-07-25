package com.studys.button_backend.DTO;

public class RegisterBody {
    private String email;
    private String password;
    private String registration;
    private Boolean admin;

    public RegisterBody(String email, String password, String registration) {
        this.email = email;
        this.password = password;
        this.registration = registration;
        this.admin = false;
    }

    public Boolean getAdmin() {return admin;}

    public void setAdmin(Boolean admin) {this.admin = admin;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getRegistration() {return registration;}

    public void setRegistration(String registration) {this.registration = registration;}
}
