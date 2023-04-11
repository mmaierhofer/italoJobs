package com.italo.jobs.company;

import com.italo.jobs.address.Address;
import com.italo.jobs.industry.Industry;
import com.italo.jobs.job.Job;
import com.italo.jobs.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name="address_id", referencedColumnName = "id")
    private Address address;
    @Column(name="industry")
    private Industry industry;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User connectedUser;
    @OneToMany(mappedBy = "company_id")
    private Set<Job> jobs;
}
