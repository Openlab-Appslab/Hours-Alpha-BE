package com.example.Hours_Alpha_v2.hour;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
        name = "hour"
)
public class Hour {

    @Id
    @SequenceGenerator(
            name = "hour_sequence",
            sequenceName = "hour_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "hour_sequence"
    )
    private Long id;

    @NonNull
    @Column(
            name = "sum_of_hour"
    )
    private Double sumOfHour;

    @NonNull
    @Column(
            name="place",
            columnDefinition = "text"
    )
    private String place;

    @NonNull
    @Column(
            name="date_of_day",
            columnDefinition = "date"
    )
    private LocalDate dateOfDay;

    @Column(
            name = "issue",
            columnDefinition = "text"
    )
    private String Issue;

    @Column(
            name="note",
            columnDefinition = "text"
    )
    private String Note;
}
