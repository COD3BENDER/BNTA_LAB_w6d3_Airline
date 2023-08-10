package com.bnta.labwk6d3airline.models;

import jakarta.persistence.Column;

public class PassengerDTO {

    private Long id;

    private String name;

    private String emailAddress;

    public PassengerDTO() {
    }

    public PassengerDTO(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
