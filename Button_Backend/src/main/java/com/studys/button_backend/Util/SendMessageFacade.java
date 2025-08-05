package com.studys.button_backend.Util;

//import com.studys.button_backend.Service.EmailService;
import com.studys.button_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SendMessageFacade {

   // private static EmailService emailService;
    private static MessageService messageService;
    private static UserRepository userRepository;

    @Autowired
    public SendMessageFacade(MessageService messageService, UserRepository userRepository) {
        this.messageService = messageService;
        this.userRepository = userRepository;
    }

    public void sendMessages(String type) {
        List<String> subject = userRepository.findAllEmails();

        for(String user: subject){
            String message = user + " recebeu mensagem do tipo " + type;
            messageService.sendText(user, message );
        }

       // emailService.sendEmailText(email, subject, message );

    }
}
