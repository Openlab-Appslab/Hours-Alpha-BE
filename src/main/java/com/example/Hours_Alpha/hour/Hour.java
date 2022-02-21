package com.example.Hours_Alpha.hour;

import com.example.Hours_Alpha.employee.Employee;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
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
    @Column(
            updatable = false
    )
    private Long id;

    @Column(
            name = "sum_of_hour",
            columnDefinition = "double",
            nullable = false
    )
    private Double sumOfHour;

    @Column(
            name = "place",
            columnDefinition = "text",
            nullable = false
    )
    private String place;

    @Column(
            name = "date_of_day",
            columnDefinition = "double",
            nullable = false
    )
    private LocalDate dateOfDay;

    @Column(
            name = "issue",
            columnDefinition = "double"
    )
    private String Issue;

    @Column(
            name = "note",
            columnDefinition = "double"
    )
    private String Note;

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "hour_id",
            referencedColumnName = "id"
    )
    private Employee employee;

    public Hour(Double sumOfHour, String place, LocalDate dateOfDay, String issue, String note) {
        this.sumOfHour = sumOfHour;
        this.place = place;
        this.dateOfDay = dateOfDay;
        Issue = issue;
        Note = note;
    }

    public Hour() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSumOfHour() {
        return sumOfHour;
    }

    public void setSumOfHour(Double sumOfHour) {
        this.sumOfHour = sumOfHour;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getDateOfDay() {
        return dateOfDay;
    }

    public void setDateOfDay(LocalDate dateOfDay) {
        this.dateOfDay = dateOfDay;
    }

    public String getIssue() {
        return Issue;
    }

    public void setIssue(String issue) {
        Issue = issue;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
