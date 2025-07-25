package com.studys.button_backend;
import java.util.ArrayList;
import java.util.List; 


public class ButtonApp implements Subject, Observer {
    private List<Observer> buttonObservers = new ArrayList<Observer>();
    private int idButton;
    private String typeButton;
    private boolean activateButton;


    public ButtonApp(int idButton,  String typeButton, boolean activateButton) {
        this.idButton = idButton;
        this.typeButton = typeButton;
        this.activateButton = activateButton;
    }

    @Override
    public void registerObserver(Observer observer){
        buttonObservers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i < buttonObservers.size(); i++){
            buttonObservers.get(i).update(true);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (buttonObservers != null && !buttonObservers.isEmpty()){
            buttonObservers.remove(observer);
        }
    }

    @Override
    public void update(Boolean sendMessage) {
        GeocalizationAdapter local = new GeocalizationAdapter("chave");
        new Alert(idButton, local, typeButton);
    }

    public void setIdButton(int idButton) {this.idButton = idButton;}

    public void setTypeButton(String typeButton) {this.typeButton = typeButton;}

    public void setActivateButton(boolean activateButton) {
        this.activateButton = activateButton;
        notifyObservers();
    }

    public int getIdButton() {return idButton;}
    public String getTypeButton() {return typeButton;}
    public boolean getActivateButton() {return activateButton;}

}