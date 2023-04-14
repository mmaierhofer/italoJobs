package com.italo.jobs.person;

import com.italo.jobs.company.Company;
import com.italo.jobs.enums.Status;
import com.italo.jobs.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "person_favority_company",
            joinColumns = { @JoinColumn(name = "id", table = "company") },
            inverseJoinColumns = { @JoinColumn(name = "id", table = "person") }
    )
    private Set<Company> favoriteCompanies;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "birthdate")
    private LocalDateTime birthdate;

    @Column(name = "status")
    private Status status;




}
