package com.ArielMelo.equipment_service.controllers;

import com.ArielMelo.equipment_service.dtos.AvailabilityResponse;
import com.ArielMelo.equipment_service.dtos.EquipmentCreateRequest;
import com.ArielMelo.equipment_service.dtos.EquipmentResponse;
import com.ArielMelo.equipment_service.entities.Equipment;
import com.ArielMelo.equipment_service.enums.EquipmentStatus;
import com.ArielMelo.equipment_service.repositorys.EquipmentRepository;
import com.ArielMelo.equipment_service.services.EquipmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    private final EquipmentService service;

    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    // ----------------------------
    // CREATE
    // ----------------------------
    @PostMapping
    public ResponseEntity<EquipmentResponse> create(
            @RequestBody @Valid EquipmentCreateRequest request) {

        Equipment equipment = Equipment.builder()
                .name(request.getName())
                .serialNumber(request.getSerialNumber())
                .category(request.getCategory())
                .purchaseDate(request.getPurchaseDate())
                .build();

        Equipment saved = service.create(equipment);

        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(saved));
    }

    // ----------------------------
    // READ
    // ----------------------------
    @GetMapping("/{id}")
    public ResponseEntity<EquipmentResponse> findById(@PathVariable Long id) {
        Equipment equipment = service.findById(id);
        return ResponseEntity.ok(toResponse(equipment));
    }

    @GetMapping
    public ResponseEntity<List<EquipmentResponse>> findAll() {
        List<Equipment> equipments = service.findAll();

        List<EquipmentResponse> response = equipments.stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    // ----------------------------
    // BUSINESS
    // ----------------------------
    @GetMapping("/{id}/available")
    public ResponseEntity<AvailabilityResponse> isAvailable(@PathVariable Long id) {
        boolean available = service.isAvailable(id);
        return ResponseEntity.ok(new AvailabilityResponse(available));
    }

    // ----------------------------
    // UPDATE STATUS
    // ----------------------------
    @PutMapping("/{id}/status")
    public ResponseEntity<EquipmentResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam EquipmentStatus status) {

        Equipment updated = service.uptadeStatus(id, status);
        return ResponseEntity.ok(toResponse(updated));
    }

    // ----------------------------
    // SOFT DELETE
    // ----------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        service.deactivate(id);
        return ResponseEntity.noContent().build();
    }

    // ----------------------------
    // MAPPER
    // ----------------------------
    private EquipmentResponse toResponse(Equipment equipment) {
        EquipmentResponse response = new EquipmentResponse();
        response.setId(equipment.getId());
        response.setName(equipment.getName());
        response.setSerialNumber(equipment.getSerialNumber());
        response.setStatus(equipment.getStatus());
        response.setCategory(equipment.getCategory());
        response.setPurchaseDate(equipment.getPurchaseDate());
        return response;
    }
 }
