package com.pankaj.wallet.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
public class Debit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    private Double amount;
    @ManyToOne
    private User debitTo;

    public User getDebitTo() {
        return debitTo;
    }

    public void setDebitTo(final User debitTo) {
        this.debitTo = debitTo;
    }

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(final Date created_at) {
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
