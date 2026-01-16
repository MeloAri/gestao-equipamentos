package com.ArielMelo.loan_service.services;

import com.ArielMelo.loan_service.CLIENT.EquipmentClient;
import com.ArielMelo.loan_service.entities.Loan;
import com.ArielMelo.loan_service.enums.LoanStatus;
import com.ArielMelo.loan_service.repositories.LoanRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository repository;
    private final EquipmentClient equipmentClient;

    @Transactional
    public Loan createLoan(Loan loan){

        boolean available =
                equipmentClient.isAvailable(loan.getEquipmentId()).isAvailable();

        if(!available){
            throw new RuntimeException("Equipamento indisponível para empréstimo");
        }

        loan.setId(null);
        loan.setLoanDate(LocalDate.now());
        loan.setStatus(LoanStatus.ACTIVE);

        return repository.save(loan);
    }


    @Transactional
    public Loan returnLoan(Long id){

        Loan loan = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Empréstimo não encontrado"));

        loan.setReturnDate(LocalDate.now());
        loan.setStatus(LoanStatus.RETURNED);

        return repository.save(loan);
    }
}
