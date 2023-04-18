package com.italo.jobs.job;

import com.italo.jobs.company.Company;
import com.italo.jobs.skill.Skill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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
    @Column(name = "description")
    private String description;
    @ManyToMany
    @JoinTable(
            name = "job_skill",
            joinColumns = { @JoinColumn(name = "job_id", table = "job", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id", table = "skill", referencedColumnName = "id") }
    )
    private List<Skill> skills;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    Company company;

}
