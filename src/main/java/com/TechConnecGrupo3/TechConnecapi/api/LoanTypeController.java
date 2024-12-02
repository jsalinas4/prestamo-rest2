package com.TechConnecGrupo3.TechConnecapi.api;

import com.TechConnecGrupo3.TechConnecapi.model.entity.LoanType;
import com.TechConnecGrupo3.TechConnecapi.repository.LoanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loan")
public class LoanTypeController {

    @Autowired
    private LoanTypeRepository loanTypeRepository;

    // Create a new loan type
    @PostMapping
    public ResponseEntity<LoanType> createLoanType(@RequestBody LoanType loanType) {
        LoanType newLoanType = loanTypeRepository.save(loanType);
        return new ResponseEntity<>(newLoanType, HttpStatus.CREATED);
    }

    // Get all loan types
    @GetMapping
    public ResponseEntity<List<LoanType>> getAllLoanTypes() {
        List<LoanType> loanTypes = loanTypeRepository.findAll();
        return new ResponseEntity<>(loanTypes, HttpStatus.OK);
    }

    // Get a loan type by ID
    @GetMapping("/{id}")
    public ResponseEntity<LoanType> getLoanTypeById(@PathVariable Long id) {
        Optional<LoanType> loanTypeOpt = loanTypeRepository.findById(id);
        return loanTypeOpt.map(loanType -> new ResponseEntity<>(loanType, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a loan type
    @PutMapping("/{id}")
    public ResponseEntity<LoanType> updateLoanType(@PathVariable Long id, @RequestBody LoanType loanTypeDetails) {
        Optional<LoanType> loanTypeOpt = loanTypeRepository.findById(id);
        if (loanTypeOpt.isPresent()) {
            LoanType loanType = loanTypeOpt.get();
            loanType.setLoanName(loanTypeDetails.getLoanName());
            loanType.setDurationMonths(loanTypeDetails.getDurationMonths());
            loanType.setInterestRate(loanTypeDetails.getInterestRate());

            LoanType updatedLoanType = loanTypeRepository.save(loanType);
            return new ResponseEntity<>(updatedLoanType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a loan type
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanType(@PathVariable Long id) {
        if (loanTypeRepository.existsById(id)) {
            loanTypeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}