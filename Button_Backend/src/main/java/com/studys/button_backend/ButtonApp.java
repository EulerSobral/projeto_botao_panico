package com.studys.button_backend;
import java.util.ArrayList;
import java.util.List;
import button_backend.Observer;


public class ButtonApp implements Subject{
    private List<Observer> buttonObservers = new ArrayList<>();
    private int idButton;
    private String typeButton;
    private Bool activateButton;

    public ButtonApp(int idButton,  String typeButton, Bool activateButton) {
        this.idButton = idButton;
        this.typeButton = typeButton;
        this.activateButton = activateButton;
    }

    @Override
    public void registerObserverButton(Observer observer){
        buttonObservers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer buttonObservers: observer){
            observer.update(true);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (buttonObservers != null and !buttonObservers.isEmpty()){
            buttonObservers.remove(observer);
        }
    }

    public void setIdButton(int idButton) {this.idButton = idButton;}

    public void setTypeButton(String typeButton) {this.typeButton = typeButton;}

    public void setActivateButton(Bool activateButton) {
        this.activateButton = activateButton;
        notifyObservers();
    }

    public int getIdButton() {return idButton;}
    public String getTypeButton() {return typeButton;}
    public Bool getActivateButton() {return activateButton;}

}