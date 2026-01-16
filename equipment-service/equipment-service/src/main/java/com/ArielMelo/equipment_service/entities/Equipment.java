package com.ArielMelo.equipment_service.entities;

import com.ArielMelo.equipment_service.enums.EquipmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NotNull
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;

    private String category;
    private LocalDate purchaseDate;

    private Boolean active = true;


}
