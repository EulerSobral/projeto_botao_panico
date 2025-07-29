package com.studys.button_backend.Service;

import com.studys.button_backend.Repository.ButtonRepository;
import org.springframework.stereotype.Service;

@Service
public class ButtonService {

  private final ButtonRepository buttonRepository;

  public ButtonService(ButtonRepository buttonRepository){this.buttonRepository = buttonRepository;}

  public void registerButton(int id, String classButton, int id_campus){

  }

  public void activateButton(int id, String classButton, int id_campus){

  }

  public void deleteButton(int id, String classButton, int id_campus){

  }




}
