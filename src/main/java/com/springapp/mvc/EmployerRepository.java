package com.springapp.mvc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Виктор on 15.10.2014.
 */
public interface EmployerRepository extends JpaRepository<Employer,Long> {
    public List<Employer> findByFirstName(String firstName);
    public List<Employer> findBySecondName(String secondName);
    public List<Employer> findByLastName(String lastName);
    public List<Employer> findByAge(int age);
    public List<Employer> findByFirstNameAndSecondNameAndLastName(String firstName, String secondName, String lastName);
    public List<Employer> findByFirstNameOrSecondNameOrLastName(String firstName, String secondName, String lastName);
}
