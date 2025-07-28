package com.studys.button_backend.Services;

public class ButtonDB {
    /*
    create table Button(
    id INTEGER auto_increment,
    class varchar(100),
    id_campus INTEGER,
);*/

  private  int id;
  private String classButton;
  private int id_campus;

  public ButtonDB(int id, String classButton, int id_campus) {
      this.id = id;
      this.classButton = classButton;
      this.id_campus = id_campus;
  }

  public void setId(int id){this.id=id;}
  public void setClassButton(String classButton){this.classButton=classButton;}
  public void setIdCampus(int id_campus){this.id_campus=id_campus;}

    public int getId(){return this.id;}
    public int getIdCampus(){return this.id_campus;}
  public String getClassButton(){return this.classButton;}



}
