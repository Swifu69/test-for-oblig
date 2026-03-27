package com.example.oblig_3_template.controller;

import com.example.oblig_3_template.model.Upgrade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.oblig_3_template.repositories.UpgradeRepository;

@RestController
@RequestMapping("/api/upgrades")
public class UpgradeController {

    private final UpgradeRepository repository;

    public UpgradeController(UpgradeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Upgrade> getAllUpgrades() {
        return repository.getAllUpgrades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Upgrade> getUpgradeById(@PathVariable Long id) {
        Optional<Upgrade> upgrade = repository.getUpgradeById(id);
        return upgrade.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createUpgrade(@RequestBody Upgrade upgrade) {
        repository.createUpgrade(upgrade);
        return ResponseEntity.ok("Upgrade created successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUpgrade(
            @PathVariable Long id, @RequestBody Upgrade upgrade) {
        int updatedRows = repository.updateUpgrade(id, upgrade);
        if (updatedRows > 0) {
            return ResponseEntity.ok("Upgrade updated successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")// Slett verdier (Delete)
    public ResponseEntity<String> deleteUpgrade(@PathVariable Long id){
        repository.deleteUpgrade(id);
        return ResponseEntity.ok("Upgrade succesfully deleted");
    }

    //TODO: full CRUD and Repository
    @GetMapping //Få verdier (READ)
    public ResponseEntity<List<Upgrade>> getAll() {

        //målet senere er at databasen skal kobles opp og disse dataene skal komme inn automatisk
        List<Upgrade> upgrades = new ArrayList<>(); // lager liste med upgrades
        //Upgrade upgrade = new Upgrade(); //lager en ny upgrade
        /*
        upgrade.setId(0); // setter verdier 
        upgrade.setCost(1200);
        upgrade.setName("Mechanical Keyboard");
        upgrade.setTitle("Not only are you productive, everyone within 10 meters knows it too.");
        upgrade.setCpsMulti(2);
        upgrade.setClickMulti(5);
        upgrades.add(upgrade); // legger upgraden til i upgrades
        */
        return ResponseEntity.ok(upgrades);
    }


}