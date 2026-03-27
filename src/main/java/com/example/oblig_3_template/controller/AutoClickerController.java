package com.example.oblig_3_template.controller;

import com.example.oblig_3_template.model.AutoClicker;
import com.example.oblig_3_template.repositories.AutoClickerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autoclickers")
public class AutoClickerController {

    private final AutoClickerRepository repository;

    public AutoClickerController(AutoClickerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AutoClicker> getAllAutoClickers() {
        return repository.getAllAutoClickers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoClicker> getAutoClickerById(@PathVariable Long id) {
        Optional<AutoClicker> autoclicker = repository.getAutoClickerById(id);
        return autoclicker.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createAutoClicker(@RequestBody AutoClicker autoclicker) {
        repository.createAutoClicker(autoclicker);
        return ResponseEntity.ok("AutoClicker created successfully!");
    }

    @GetMapping("/test")
    public String test(){
        return("test created successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAutoClicker(
            @PathVariable Long id, @RequestBody AutoClicker autoclicker) {
        int updatedRows = repository.updateAutoClicker(id, autoclicker);
        if (updatedRows > 0) {
            return ResponseEntity.ok("AutoClicker updated successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}