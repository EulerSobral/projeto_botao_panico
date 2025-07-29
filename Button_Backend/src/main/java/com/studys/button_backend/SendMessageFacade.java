package com.studys.button_backend;

import com.studys.button_backend.DTO.LoginBody;
import com.studys.button_backend.DTO.RegisterBody;
import com.studys.button_backend.Service.EmailService;
import com.studys.button_backend.Service.UserService;


public class SendMessageFacade {
    private EmailService emailService;

    public SendMessageFacade(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendMessages(RegisterBody user){
        String subject = "E-mail enviado com sucesso";
        String message = "Hello World";
        emailService.sendEmailText(user.getEmail(), subject, message );
    }
}
