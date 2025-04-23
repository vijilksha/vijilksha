package com.cts.training.service;

import com.cts.training.dto.SwipeRequest;
import com.cts.training.dto.TopUpRequest;
import com.cts.training.model.Employee;
import com.cts.training.model.TimeEntry;
import com.cts.training.repo.EmployeeRepository;
import com.cts.training.repo.TimeEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TimeEntryService {

    private final EmployeeRepository employeeRepo;
    private final TimeEntryRepository timeEntryRepo;

    public TimeEntryService(EmployeeRepository employeeRepo, TimeEntryRepository timeEntryRepo) {
        this.employeeRepo = employeeRepo;
        this.timeEntryRepo = timeEntryRepo;
    }

    public ResponseEntity<String> swipe(SwipeRequest request) {
        log.info("Processing swipe for employeeId: {}", request.getEmployeeId());

        Optional<Employee> empOpt = employeeRepo.findById(request.getEmployeeId());
        if (empOpt.isEmpty()) {
            log.warn("Employee not found with ID: {}", request.getEmployeeId());
            return ResponseEntity.badRequest().body("Employee not found.");
        }
        Employee emp = empOpt.get();

        LocalDate today = request.getTimestamp().toLocalDate();
        List<TimeEntry> entries = timeEntryRepo.findByEmployeeIdAndDate(emp.getId(), today);

        TimeEntry entry = entries.isEmpty() ? new TimeEntry() : entries.get(0);
        entry.setEmployee(emp);
        entry.setDate(today);

        if (request.isSwipeIn()) {
            log.info("Swipe-in at {}", request.getTimestamp());
            entry.setSwipeIn(request.getTimestamp());
        } else {
            log.info("Swipe-out at {}", request.getTimestamp());
            entry.setSwipeOut(request.getTimestamp());
        }

        timeEntryRepo.save(entry);
        return ResponseEntity.ok("Swipe recorded.");
    }

    public ResponseEntity<String> topUp(TopUpRequest request) {
        log.info("Top-up request for employeeId: {}, minutes: {}", request.getEmployeeId(), request.getMinutes());

        Optional<Employee> empOpt = employeeRepo.findById(request.getEmployeeId());
        if (empOpt.isEmpty()) {
            log.warn("Employee not found with ID: {}", request.getEmployeeId());
            return ResponseEntity.badRequest().body("Employee not found.");
        }
        Employee emp = empOpt.get();

        LocalDate today = LocalDate.now();
        List<TimeEntry> entries = timeEntryRepo.findByEmployeeIdAndDate(emp.getId(), today);
        TimeEntry entry = entries.isEmpty() ? new TimeEntry() : entries.get(0);

        if (entry.getTopUpMinutes() >= 30 * 3) {
            log.warn("Top-up limit exceeded for employeeId: {}", emp.getId());
            return ResponseEntity.badRequest().body("Top-up limit exceeded!");
        }

        if (entry.getSwipeIn() != null && entry.getSwipeOut() != null) {
            long actualMinutes = Duration.between(entry.getSwipeIn(), entry.getSwipeOut()).toMinutes();
            if (actualMinutes >= 600) {
                log.info("No need for top-up. Already worked 10 hours.");
                return ResponseEntity.ok("No need for top-up. 10 hours already completed.");
            }
        }

        entry.setEmployee(emp);
        entry.setDate(today);
        entry.setTopUpMinutes(entry.getTopUpMinutes() + request.getMinutes());

        timeEntryRepo.save(entry);
        log.info("Top-up successful for employeeId: {}", emp.getId());
        return ResponseEntity.ok("Top-up successful.");
    }

    
    
    public ResponseEntity<List<TimeEntry>> getAllEntries() {
        log.info("Fetching all entries");

        List<TimeEntry> entries = timeEntryRepo.findAll();

        if (entries.isEmpty()) {
            log.warn("No entries found");
            return ResponseEntity.noContent().build(); // or .ok(Collections.emptyList()) if you want to return 200
        }

        return ResponseEntity.ok(entries);
    }

    

    public ResponseEntity<String> approveEntry(Long entryId) {
        log.info("Manager approval for entryId: {}", entryId);

        Optional<TimeEntry> entryOpt = timeEntryRepo.findById(entryId);
        if (entryOpt.isEmpty()) {
            log.warn("TimeEntry not found for id: {}", entryId);
            return ResponseEntity.badRequest().body("Entry not found.");
        }

        TimeEntry entry = entryOpt.get();
        entry.setApproved(true);
        timeEntryRepo.save(entry);

        log.info("Entry approved successfully: {}", entryId);
        return ResponseEntity.ok("Entry approved by manager.");
    }
}
