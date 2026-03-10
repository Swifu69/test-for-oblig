package com.example.oblig_3_template.controller;

import com.example.oblig_3_template.model.Upgrade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/upgrades")
public class UpgradeController {

    //TODO: full CRUD and Repository
    @GetMapping
    public ResponseEntity<List<Upgrade>> getAll() {
        List<Upgrade> upgrades = new ArrayList<>();
        Upgrade upgrade = new Upgrade();
        upgrade.setId(0);
        upgrade.setCost(1200);
        upgrade.setName("Mechanical Keyboard");
        upgrade.setTitle("Not only are you productive, everyone within 10 meters knows it too.");
        upgrade.setCpsMulti(2);
        upgrade.setClickMulti(5);
        upgrades.add(upgrade);
        return ResponseEntity.ok(upgrades);
    }

}