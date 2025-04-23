package com.cts.training.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeEntryDTO {

    private Long id;
    private Long employeeId;
    private LocalDate date;
    private LocalDateTime swipeIn;
    private LocalDateTime swipeOut;
    private int topUpMinutes;
    private boolean approved;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getSwipeIn() {
        return swipeIn;
    }

    public void setSwipeIn(LocalDateTime swipeIn) {
        this.swipeIn = swipeIn;
    }

    public LocalDateTime getSwipeOut() {
        return swipeOut;
    }

    public void setSwipeOut(LocalDateTime swipeOut) {
        this.swipeOut = swipeOut;
    }

    public int getTopUpMinutes() {
        return topUpMinutes;
    }

    public void setTopUpMinutes(int topUpMinutes) {
        this.topUpMinutes = topUpMinutes;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
