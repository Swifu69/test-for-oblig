package com.example.oblig_3_template.controller;

import com.example.oblig_3_template.model.Upgrade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.example.oblig_3_template.repositories.UpgradeRepository;

@RestController
@RequestMapping("/api/upgrades")
public class UpgradeController {

    private final UpgradeRepository repository;

    public UpgradeController(UpgradeRepository repository) {
        this.repository = repository;
    }

/* //kommentert ut midlertidig
    //TODO: full CRUD and Repository
    @GetMapping //Få verdier (READ)
    public ResponseEntity<List<Upgrade>> getAll() {

        //målet senere er at databasen skal kobles opp og disse dataene skal komme inn automatisk
        List<Upgrade> upgrades = new ArrayList<>(); // lager liste med upgrades
        Upgrade upgrade = new Upgrade(); //lager en ny upgrade
        upgrade.setId(0); // setter verdier 
        upgrade.setCost(1200);
        upgrade.setName("Mechanical Keyboard");
        upgrade.setTitle("Not only are you productive, everyone within 10 meters knows it too.");
        upgrade.setCpsMulti(2);
        upgrade.setClickMulti(5);
        upgrades.add(upgrade); // legger upgraden til i upgrades
        return ResponseEntity.ok(upgrades);
    }
    */
/*
    @PostMapping() // Lag verdier (Create)
    @PutMapping() // Oppdater verdier (Update)
    @DeleteMapping() // Slett verdier (Delete)
*/

}