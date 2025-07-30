package com.studys.button_backend.Controller;

import com.studys.button_backend.Service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/Alert")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService){
        this.alertService = alertService;
    }

    @PostMapping
    public ResponseEntity<?> sendAlert(@RequestBody Map<String, String> alert, @RequestHeader("Authorization") String token){
        try{
            String local = alert.get("local");
            String id_button = alert.get("id_button");
            String type = alert.get("type");
            String date = alert.get("date");

            LocalDate localDate = LocalDate.parse(date);

            Boolean result = false;

            if(local != null && token != null){
                String tokenAdjusted;
                tokenAdjusted = token.substring(7);
                result = alertService.sendAlert(local, type, localDate, tokenAdjusted);
            }
            else if(id_button != null){
                int idButton = Integer.parseInt(id_button);
                result = alertService.sendAlert(idButton, type, localDate);
            }

            if(result) return ResponseEntity.status(200).body("sent alert");
            else return ResponseEntity.status(400).body("failed to send alert");
        }
        catch(Exception e){return ResponseEntity.status(400).body("Error");
    }
}}
