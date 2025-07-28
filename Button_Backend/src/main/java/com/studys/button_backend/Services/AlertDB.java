package com.studys.button_backend.Services;
import java.time.LocalDate;

public class AlertDB {

    private int id;
    private int id_button;
    private String local;
    private String type;
    private LocalDate data;

    public AlertDB(int id, int id_button, String local, String type,LocalDate data){
        this.id = id;
        this.id_button = id_button;
        this.local = local;
        this.type = type;
        this.data = data;
    }

    public void setId(int id){this.id=id;}
    public void setIdButton(int id_button){this.id_button=id_button;}
    public void setLocal(String local){this.local=local;}
    public void setType(String type){this.type=type;}
    public void setData(LocalDate data){this.data=data;}

    public int getIdButton(){return this.id_button;}
    public String getLocal(){return this.local;}
    public String getType(){return this.type;}
    public LocalDate getData(){return this.data;}
}
