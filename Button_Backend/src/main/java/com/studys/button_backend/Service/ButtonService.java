package com.studys.button_backend.Service;

import com.studys.button_backend.Interface.ButtonObserverInterface;
import com.studys.button_backend.Repository.ButtonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ButtonService  {

  private final ButtonRepository buttonRepository;
  private final List<ButtonObserverInterface> observers;

  public ButtonService(ButtonRepository buttonRepository,  List<ButtonObserverInterface> observers) {
    this.buttonRepository = buttonRepository;
    this.observers = observers;
  }

  public Boolean registerButton(String classButton, int id_campus){

    for (ButtonObserverInterface observer : observers) {
      observer.buttonCreated(classButton, id_campus);
    }

    return buttonRepository.register(classButton, id_campus);
  }


  public Boolean deleteButton(int id_campus){
    return buttonRepository.delete(id_campus);
  }

}
