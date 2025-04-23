package com.cts.training.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.training.model.TimeEntry;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
    
    // Get all entries for a specific employee
    List<TimeEntry> findByEmployeeId(Long employeeId);

    // Get entry for a specific employee on a specific date
    List<TimeEntry> findByEmployeeIdAndDate(Long employeeId, LocalDate date);

    // Get all entries in a date range (e.g., for weekly calculation)
    List<TimeEntry> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate startDate, LocalDate endDate);
}