package com.example.oblig_3_template.controller;

import com.example.oblig_3_template.model.AutoClicker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/autoclickers")
public class AutoClickerController {

    //TODO: full CRUD and Repository
    @GetMapping
    public ResponseEntity<List<AutoClicker>> getAll() {
        //målet senere er at databasen skal kobles opp og disse dataene skal komme inn automatisk
        List<AutoClicker> autoClickers = new ArrayList<AutoClicker>(); // lager en arraylist med autoclickers
        AutoClicker autoClicker = new AutoClicker(); // lager et autoclicker objekt
        autoClicker.setId(0); // legger til verdier i objectet
        autoClicker.setCost(15);
        autoClicker.setCps(1);
        autoClicker.setName("Nod Thoughtfully During Lectures");
        autoClicker.setTitle("No one knows what you understood, but it looks impressive.");
        autoClickers.add(autoClicker); // legger til autoclickeren i autoclick arrayen
        return ResponseEntity.ok(autoClickers);
    }
    @PostMapping() // Lag verdier (Create)
    @PutMapping() // Oppdater verdier (Update)
    @DeleteMapping() // Slett verdier (Delete)
}