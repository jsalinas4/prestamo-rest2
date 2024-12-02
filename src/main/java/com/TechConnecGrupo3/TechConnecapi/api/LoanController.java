package com.TechConnecGrupo3.TechConnecapi.api;

import com.TechConnecGrupo3.TechConnecapi.model.entity.Loan;
import com.TechConnecGrupo3.TechConnecapi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    // Create a new loan
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan newLoan = loanRepository.save(loan);
        return new ResponseEntity<>(newLoan, HttpStatus.CREATED);
    }

    // Get all loans
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanRepository.findAll();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    // Get a loan by ID
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Optional<Loan> loanOpt = loanRepository.findById(id);
        return loanOpt.map(loan -> new ResponseEntity<>(loan, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a loan
    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loanDetails) {
        Optional<Loan> loanOpt = loanRepository.findById(id);
        if (loanOpt.isPresent()) {
            Loan loan = loanOpt.get();
            loan.setAmount(loanDetails.getAmount());
            loan.setLoanDate(loanDetails.getLoanDate());
            loan.setStartDate(loanDetails.getStartDate());
            loan.setDurationMonths(loanDetails.getDurationMonths());
            loan.setInterestRate(loanDetails.getInterestRate());

            Loan updatedLoan = loanRepository.save(loan);
            return new ResponseEntity<>(updatedLoan, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a loan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        if (loanRepository.existsById(id)) {
            loanRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}