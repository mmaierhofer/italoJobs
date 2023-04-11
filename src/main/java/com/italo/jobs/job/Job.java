package com.italo.jobs.job;

import com.italo.jobs.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "start_date")
    private LocalDate startDate;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    Company company;
}
