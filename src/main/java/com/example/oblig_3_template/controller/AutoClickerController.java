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
        List<AutoClicker> autoClickers = new ArrayList<AutoClicker>();
        AutoClicker autoClicker = new AutoClicker();
        autoClicker.setId(0);
        autoClicker.setCost(15);
        autoClicker.setCps(1);
        autoClicker.setName("Nod Thoughtfully During Lectures");
        autoClicker.setTitle("No one knows what you understood, but it looks impressive.");
        autoClickers.add(autoClicker);
        return ResponseEntity.ok(autoClickers);
    }

}