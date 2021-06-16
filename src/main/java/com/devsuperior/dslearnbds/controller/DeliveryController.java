package com.devsuperior.dslearnbds.controller;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.service.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliverService service;

    @PutMapping("/{id}")
    public ResponseEntity<Void> saveRevison(@PathVariable Long id, @RequestBody DeliverRevisionDTO dto) {
        service.saveRevision(id, dto);
        return ResponseEntity.noContent().build();
    }

}
