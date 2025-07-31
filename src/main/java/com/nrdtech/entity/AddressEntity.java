package com.nrdtech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class AddressEntity {

    @Id
    private int id;
    private String lan1;
    private String lan2;
    private long zip;
    private String state;

    public AddressEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLan1() {
        return lan1;
    }

    public void setLan1(String lan1) {
        this.lan1 = lan1;
    }

    public String getLan2() {
        return lan2;
    }

    public void setLan2(String lan2) {
        this.lan2 = lan2;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
