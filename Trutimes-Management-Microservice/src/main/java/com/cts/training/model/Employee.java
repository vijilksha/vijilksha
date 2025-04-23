package com.cts.training.model;

import javax.persistence.Column;
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
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "Employee entity representing a company employee or manager")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Employee ID")
    private Long id;

    @ApiModelProperty(value = "Full name of the employee", example = "John Doe")
    private String name;

    @Column(unique = true)
    @ApiModelProperty(value = "Unique email address", example = "john.doe@company.com")
    private String email;

    @ApiModelProperty(value = "Role of the employee (EMPLOYEE or MANAGER)", example = "EMPLOYEE")
    private String role;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @ApiModelProperty(value = "Manager associated with this employee")
    private Employee manager;

    @OneToMany(mappedBy = "employee")
    @ApiModelProperty(value = "Time entries recorded for this employee")
    private List<TimeEntry> timeEntries;
}
