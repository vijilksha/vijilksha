package com.cts.training.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@ApiModel(description = "Time entry entity representing swipe-in/swipe-out and top-up info")
public class TimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Time entry ID", example = "100", position = 0)
    private Long id;

    @ApiModelProperty(notes = "Entry date", example = "2025-04-19", position = 1)
    private LocalDate date;

    @ApiModelProperty(notes = "Swipe in time", example = "2025-04-19T09:00:00", position = 2)
    private LocalDateTime swipeIn;

    @ApiModelProperty(notes = "Swipe out time", example = "2025-04-19T18:00:00", position = 3)
    private LocalDateTime swipeOut;

    @ApiModelProperty(notes = "Top-up minutes added if not completing 10 hrs", example = "30", position = 4)
    private int topUpMinutes = 0;

    @ApiModelProperty(notes = "Whether the manager approved the entry", example = "false", position = 5)
    private boolean approved = false;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @ApiModelProperty(notes = "Employee who made this time entry", position = 6)
    private Employee employee;
}
