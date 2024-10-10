package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name = "ious")

public class IOU {

    @Id // Marks this field as the primary key.
    @GeneratedValue(strategy = GenerationType.UUID) 
    public UUID id;

    public String borrower;

    public BigDecimal amount;

    public Instant dateTime;

    public String lender;

    // no arg constructor
    public IOU(){

    }

    //Getters and setters

    public UUID getId() {
        return id;
    }

    
    public String getBorrower() {
        return borrower;
    }
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }


    public String getLender() {
        return lender;
    }
    public void setLender(String lender) {
        this.lender = lender;
    }


    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public Instant getDateTime() {
        return dateTime;
    }
    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

}
