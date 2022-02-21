package com.example.Hours_Alpha.company;

import com.example.Hours_Alpha.boss.Boss;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "company"
)
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "company_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    @OneToOne(mappedBy = "company")
    private Boss boss;

    public Company() {
    }
}
