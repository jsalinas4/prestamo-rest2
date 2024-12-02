package com.TechConnecGrupo3.TechConnecapi.api;

import com.TechConnecGrupo3.TechConnecapi.model.entity.PaymentSchedule;
import com.TechConnecGrupo3.TechConnecapi.repository.PaymentScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentScheduleController {

    @Autowired
    private PaymentScheduleRepository paymentScheduleRepository;

    // Create a new payment schedule
    @PostMapping
    public ResponseEntity<PaymentSchedule> createPaymentSchedule(@RequestBody PaymentSchedule paymentSchedule) {
        PaymentSchedule newPaymentSchedule = paymentScheduleRepository.save(paymentSchedule);
        return new ResponseEntity<>(newPaymentSchedule, HttpStatus.CREATED);
    }

    // Get all payment schedules
    @GetMapping
    public ResponseEntity<List<PaymentSchedule>> getAllPaymentSchedules() {
        List<PaymentSchedule> paymentSchedules = paymentScheduleRepository.findAll();
        return new ResponseEntity<>(paymentSchedules, HttpStatus.OK);
    }

    // Get a payment schedule by ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentSchedule> getPaymentScheduleById(@PathVariable Long id) {
        Optional<PaymentSchedule> scheduleOpt = paymentScheduleRepository.findById(id);
        return scheduleOpt.map(schedule -> new ResponseEntity<>(schedule, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a payment schedule
    @PutMapping("/{id}")
    public ResponseEntity<PaymentSchedule> updatePaymentSchedule(@PathVariable Long id, @RequestBody PaymentSchedule scheduleDetails) {
        Optional<PaymentSchedule> scheduleOpt = paymentScheduleRepository.findById(id);
        if (scheduleOpt.isPresent()) {
            PaymentSchedule schedule = scheduleOpt.get();
            schedule.setPaymentDate(scheduleDetails.getPaymentDate());
            schedule.setInstallmentNumber(scheduleDetails.getInstallmentNumber());
            schedule.setInstallmentAmount(scheduleDetails.getInstallmentAmount());
            schedule.setInterestAmount(scheduleDetails.getInterestAmount());
            schedule.setInstallmentStatus(scheduleDetails.getInstallmentStatus());

            PaymentSchedule updatedSchedule = paymentScheduleRepository.save(schedule);
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a payment schedule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentSchedule(@PathVariable Long id) {
        if (paymentScheduleRepository.existsById(id)) {
            paymentScheduleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}