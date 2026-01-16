package com.ArielMelo.equipment_service.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EquipmentCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String serialNumber;

    private String category;
    private LocalDate purchaseDate;
}
