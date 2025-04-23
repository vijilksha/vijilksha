package com.cts.training.dto;

import java.time.LocalDateTime;

public class SwipeRequest {

    private Long employeeId;
    private LocalDateTime timestamp;
    private boolean swipeIn;

    // Getters and Setters
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSwipeIn() {
        return swipeIn;
    }

    public void setSwipeIn(boolean swipeIn) {
        this.swipeIn = swipeIn;
    }
}
