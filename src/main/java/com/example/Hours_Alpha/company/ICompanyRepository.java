package com.example.Hours_Alpha.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface ICompanyRepository extends JpaRepository<Company, Long> {
}
