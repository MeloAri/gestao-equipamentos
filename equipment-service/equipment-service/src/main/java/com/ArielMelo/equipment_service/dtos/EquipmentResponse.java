package com.ArielMelo.equipment_service.dtos;

import com.ArielMelo.equipment_service.enums.EquipmentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EquipmentResponse {

    private Long id;
    private String name;
    private String serialNumber;
    private EquipmentStatus status;
    private String category;
    private LocalDate purchaseDate;
}
