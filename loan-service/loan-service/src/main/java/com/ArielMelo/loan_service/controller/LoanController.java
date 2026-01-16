package com.ArielMelo.loan_service.controller;

import com.ArielMelo.loan_service.entities.Loan;
import com.ArielMelo.loan_service.services.LoanService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Loan> create(@RequestBody @Valid Loan loan){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(loanService.createLoan(loan));
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Loan> returnLoan(@PathVariable Long id){
        return ResponseEntity.ok(loanService.returnLoan(id));
    }



}
