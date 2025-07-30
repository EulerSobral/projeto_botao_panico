package com.studys.button_backend;

import com.studys.button_backend.DTO.LoginBody;
import com.studys.button_backend.DTO.RegisterBody;
import com.studys.button_backend.Service.EmailService;
import com.studys.button_backend.Service.UserService;


public class SendMessageFacade {
    private static EmailService emailService;

    public SendMessageFacade(EmailService emailService) {
        SendMessageFacade.emailService = emailService;
    }

    public static void sendMessages(String email) {
        String subject = "E-mail enviado com sucesso";
        String message = "Hello World";
        emailService.sendEmailText(email, subject, message );
    }
}
