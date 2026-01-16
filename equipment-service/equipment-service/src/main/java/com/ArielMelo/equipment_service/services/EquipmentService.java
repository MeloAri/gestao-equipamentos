package com.ArielMelo.equipment_service.services;

import com.ArielMelo.equipment_service.entities.Equipment;
import com.ArielMelo.equipment_service.enums.EquipmentStatus;
import com.ArielMelo.equipment_service.exception.BusinessException;
import com.ArielMelo.equipment_service.repositorys.EquipmentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;


    @Transactional
    public Equipment create(Equipment equipment){

        if(equipmentRepository.existsBySerialNumber(equipment.getSerialNumber())){
            throw new BusinessException("Já existe equipamento com esse número de série");
        }

        equipment.setId(null);
        equipment.setStatus(EquipmentStatus.DISPONIVEL);
        equipment.setActive(true);

        return equipmentRepository.save(equipment);
    }

    public Equipment findById(Long id){
       return equipmentRepository.findById(id)
                .filter(Equipment::getActive)
                .orElseThrow(()-> new BusinessException("Equipamento não encontrado"));
    }

    public List<Equipment> findAll(){
        return equipmentRepository.findAll();
    }

    @Transactional
    public boolean isAvailable(Long id) {
        Equipment equipment = findById(id);
        return equipment.getStatus() == EquipmentStatus.DISPONIVEL;
    }

    @Transactional
    public Equipment uptadeStatus(Long id, EquipmentStatus newStatus){
        Equipment equipment = findById(id);
        equipment.setStatus(newStatus);
        return equipmentRepository.save(equipment);
    }

    public void deactivate(Long id){
        Equipment equipment = findById(id);
        equipment.setActive(false);
        equipmentRepository.save(equipment);
    }
}
