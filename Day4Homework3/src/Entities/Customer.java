package Entities;

import Abstract.Entity;

import java.time.LocalDate;

public class Customer implements Entity {
    private int id;
    private String firstName;
    private String lastName;
    private String nationalityId;
    private LocalDate dateOfBirth;

    public Customer(int id, String firstName, String lastName, String nationalityId, LocalDate dateOfBirth) {
        super();
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setNationalityId(nationalityId);
        this.setDateOfBirth(dateOfBirth);
    }

    public Customer(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
