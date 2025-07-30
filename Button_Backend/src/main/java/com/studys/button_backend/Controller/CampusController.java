package com.studys.button_backend.Controller;

import com.studys.button_backend.Service.CampusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Campus")
public class CampusController {

    private final CampusService campusService;

    public CampusController(CampusService campusService){
        this.campusService = campusService;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Map<String,String> campus){
        try{
            String className = campus.get("class");

            Boolean result = campusService.registerCampus(className);

            if(result) return ResponseEntity.status(200).body("Campus registered successfully");
            else return ResponseEntity.status(400).body("Campus registration failed");
        }
        catch(Exception e){return ResponseEntity.status(400).body("Campus registration failed");}
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody int id_campus){
        try{
            Boolean result = campusService.deleteCampus(id_campus);

            if(result) return ResponseEntity.status(200).body("Campus deleted successfully");
            else return ResponseEntity.status(400).body("Campus deletion failed");
        }
        catch(Exception e){return ResponseEntity.status(400).body("Campus deletion failed");}
    }
}
