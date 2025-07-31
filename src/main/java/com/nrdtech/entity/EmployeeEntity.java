package com.nrdtech.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class EmployeeEntity {

    public EmployeeEntity() {
    }

    @Id
    private int id;
    private String name;
    private String email;
    private String bloodGroup;
    //private AddressEntity address;

    public EmployeeEntity(int id, String name, String email, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bloodGroup = bloodGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /*public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }*/
}

