//package com.studys.button_backend;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.studys.button_backend.DTO.Alert;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//public class ButtonApp implements Subject, Observer {
//    private List<Observer> buttonObservers = new ArrayList<Observer>();
//    private int idButton;
//    private String typeButton;
//    private boolean activateButton;
//
//
//    public ButtonApp(List<Observer> buttonObservers, int idButton,  String typeButton, boolean activateButton) {
//        this.buttonObservers = buttonObservers;
//        this.idButton = idButton;
//        this.typeButton = typeButton;
//        this.activateButton = activateButton;
//    }
//
//    @Override
//    public void registerObserver(Observer observer){
//        buttonObservers.add(observer);
//    }
//
//    @Override
//    public void notifyObservers() {
//        for(int i = 0; i < buttonObservers.size(); i++){
//            buttonObservers.get(i).update(true, "uehruey");
//        }
//    }
//
//    @Override
//    public void removeObserver(Observer observer) {
//        if (buttonObservers != null && !buttonObservers.isEmpty()){
//            buttonObservers.remove(observer);
//        }
//    }
//
//    @Override
//    public ResponseEntity<String> update(Boolean sendMessage,
//                                          LocationAdapter locationAdapter) {
//        GeocalizationAdapter geocalizationAdapter = new GeocalizationAdapter("chave");
//        double latidude = locationAdapter.getLatitude();
//        double longitude = locationAdapter.getLongitude();
//        String locationName = geocalizationAdapter.findLocation(latidude, longitude);
//        Alert alert = new Alert(idButton, locationName, typeButton);
//        return ResponseEntity.ok(alert.toString());
//    }
//
//    public void setIdButton(int idButton) {this.idButton = idButton;}
//
//    public void setTypeButton(String typeButton) {this.typeButton = typeButton;}
//
//    public void setActivateButton(boolean activateButton) {
//        this.activateButton = activateButton;
//        notifyObservers();
//    }
//
//    public int getIdButton() {return idButton;}
//    public String getTypeButton() {return typeButton;}
//    public boolean getActivateButton() {return activateButton;}
//
//}