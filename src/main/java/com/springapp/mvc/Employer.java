package com.springapp.mvc;
import javax.persistence.*;
/**
 * Created by Виктор on 15.10.2014.
 */
@Entity
public class Employer {
    @Id
    @GeneratedValue
    private long id;

    @Basic
    private String firstName;

    @Basic
    private String secondName;

    @Basic
    private String lastName;

    @Basic
    private int age;

    @Basic
    private int experience;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    private String description;

}
