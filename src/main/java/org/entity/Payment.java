package org.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "payment", schema = "movie")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Short paymentId;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "rental_id")
    private Rental rental;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Short getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Short paymentId) {
        this.paymentId = paymentId;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Payment() {
    }

    public Payment(BigDecimal amount, Customer customer, LocalDateTime lastUpdate, LocalDateTime paymentDate, Short paymentId, Rental rental, Staff staff) {
        this.amount = amount;
        this.customer = customer;
        this.lastUpdate = lastUpdate;
        this.paymentDate = paymentDate;
        this.paymentId = paymentId;
        this.rental = rental;
        this.staff = staff;
    }
}
