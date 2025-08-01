package com.studys.button_backend.Controller;

import com.studys.button_backend.Service.ButtonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

@RequestMapping("/Button")
public class ButtonController {

    private final ButtonService buttonService;

    public ButtonController(ButtonService buttonService){
        this.buttonService = buttonService;
    }

    @PostMapping
    public ResponseEntity<?> registerButton(@RequestBody Map<String,String> button){
        try{
            String className = button.get("class");
            int id_campus = Integer.parseInt(button.get("id_campus"));

            Boolean result = buttonService.registerButton(className, id_campus);

            if(result) return ResponseEntity.status(200).body("Button registered successfully");
            else return ResponseEntity.status(400).body("Button registration failed");
        }
        catch(Exception e){return ResponseEntity.status(400).body("Button registration failed");}
    }

    @DeleteMapping
    public ResponseEntity<?> deleteButton(@RequestBody int id_button){
        try{
            Boolean result = buttonService.deleteButton(id_button);

            if(result) return ResponseEntity.status(200).body("Button deleted successfully");
            else return ResponseEntity.status(400).body("Button not found");
        }
        catch(Exception e){return ResponseEntity.status(404).body("error to access to data");}
    }
}
