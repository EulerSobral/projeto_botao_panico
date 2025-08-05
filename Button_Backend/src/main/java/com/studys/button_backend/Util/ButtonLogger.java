package com.studys.button_backend.Util;

import com.studys.button_backend.Interface.ButtonObserverInterface;
import org.springframework.stereotype.Component;

@Component
public class ButtonLogger implements ButtonObserverInterface {
    @Override
    public void buttonCreated(String className, int idCampus ) {

        System.out.println("Botão: Classe " + className + ", IdCampus " + idCampus);
    }
}
