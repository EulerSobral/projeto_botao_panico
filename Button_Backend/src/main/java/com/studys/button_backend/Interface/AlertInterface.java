package com.studys.button_backend.Interface;

import java.time.LocalDate;

public interface AlertInterface {

    public Boolean sendAlert(int id_button, String type, LocalDate data);


    public Boolean sendAlert(String local, String type, LocalDate data, String token);
}
