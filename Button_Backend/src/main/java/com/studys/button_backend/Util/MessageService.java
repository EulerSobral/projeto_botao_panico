package com.studys.button_backend.Util;


import org.springframework.stereotype.Component;

@Component
public class MessageService {


    private String sender;
    private  String subject;
    private  String  message;

    public MessageService(){

    }

    public MessageService( String sender, String subject, String message) {
         this.sender = sender;
         this.subject = subject;
         this.message = message;
    }

    public void setSender(String sender) {this.sender = sender;}
    public void setSubject(String subject) {this.subject = subject;}
    public void setMessage(String message) {this.message = message;}

    public String getSender() {return sender;}
    public String getSubject() {return subject;}
    public String getMessage() {return message;}


    public String sendText(String subject, String message){
        try{
            System.out.println(message);
            return message;
        }catch (Exception e){
            System.out.println("erro no envio da mensagem");
            return "Erro ao enviar mesage!" + e;
        }
    }
}
