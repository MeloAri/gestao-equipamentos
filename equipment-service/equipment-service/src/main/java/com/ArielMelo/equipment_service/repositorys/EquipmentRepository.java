package com.ArielMelo.equipment_service.repositorys;

import com.ArielMelo.equipment_service.entities.Equipment;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    Optional<Equipment> findBySerialNumber(String serialNumber);

    boolean existsBySerialNumber (String serialNumber);
}
