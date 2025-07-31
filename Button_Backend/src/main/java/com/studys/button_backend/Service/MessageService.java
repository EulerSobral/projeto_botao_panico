package com.studys.button_backend.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.stereotype.Service;

//@Service
public class MessageService {

    private String sender;
    private String subject;
    private String  message;

    public MessageService(String sender,  String subject, String message) {
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

    public String sendText(String recipient, String subject, String message){
        try{
            System.out.println(message);
            return "mensagem enviada com sucesso!";
        }catch (Exception e){
            System.out.println("erro no envio da mensagem");
            return "Erro ao enviar email!" + e.getLocalizedMessage();
        }
    }
}
