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
        /*AutoClicker autoClicker = new AutoClicker(); // lager et autoclicker objekt
        autoClicker.setId(0); // legger til verdier i objectet
        autoClicker.setCost(15);
        autoClicker.setCps(1);
        autoClicker.setName("Nod Thoughtfully During Lectures");
        autoClicker.setTitle("No one knows what you understood, but it looks impressive.");
        autoClickers.add(autoClicker); // legger til autoclickeren i autoclick arrayen*/
        return ResponseEntity.ok(autoClickers);
    }

    @PostMapping // Lag verdier (Create)
    public ResponseEntity <AutoClicker> createAll(@RequestBody AutoClicker autoClicker){
        return ResponseEntity.ok(autoClicker);
    }

    @PutMapping("/{id}") // Oppdater verdier (Update)
    public ResponseEntity <AutoClicker> updateAll(@RequestBody AutoClicker autoClicker, @PathVariable int id){
        autoClicker.setId(id);
        return ResponseEntity.ok(autoClicker);

    }

    @DeleteMapping("/{id}") // Slett verdier (Delete)
    public ResponseEntity<Void> deleteAll(@PathVariable int id){
        return ResponseEntity.noContent().build();
    }

}