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

// to be checked out
// Check your database contains an "ious" table with the correct columns and data types
// above returns empty set, why

@Entity
@Table(name = "ious")

public class IOU {

    @Id // Marks this field as the primary key.
    @GeneratedValue(strategy = GenerationType.UUID) 
   // @Column(name = "id", updatable = false, nullable = false)
    public UUID id;

   // @Column(name = "borrower", nullable = false)
    public String borrower;

    //@Column(name = "amount", nullable = false, precision = 19, scale = 2)
    public BigDecimal amount;

   // @Column(name = "dateTime", nullable = false)
    public Instant dateTime;

   // @Column(name = "lender", nullable = false)
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
