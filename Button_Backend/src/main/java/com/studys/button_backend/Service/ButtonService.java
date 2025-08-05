package com.studys.button_backend.Service;

import com.studys.button_backend.Interface.ButtonInterface;
import com.studys.button_backend.Repository.ButtonRepository;
import org.springframework.stereotype.Service;

@Service
public class ButtonService /*implements ButtonInterface */{

  private final ButtonRepository buttonRepository;

  public ButtonService(ButtonRepository buttonRepository){
    this.buttonRepository = buttonRepository;
  }

  public Boolean registerButton(String classButton, int id_campus){
    return buttonRepository.register(classButton, id_campus);
  }

//  public Boolean activateButton(String classButton, int id_campus){
//    return buttonRepository.
//  }

  public Boolean deleteButton(int id_campus){
    return buttonRepository.delete(id_campus);
  }

}
