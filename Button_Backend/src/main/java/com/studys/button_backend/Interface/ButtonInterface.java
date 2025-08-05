package com.studys.button_backend.Interface;

public interface ButtonInterface {

    public Boolean registerButton(String classButton, int id_campus, String token);

    public Boolean deleteButton(int id_campus, String token);
}
