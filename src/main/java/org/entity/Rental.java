package org.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;
@Entity
@Table(name = "rental", schema = "movie")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer rentalId;
    @Column(name = "rental_date")
    private LocalDateTime rentalDate;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Rental() {
    }

    public Rental(Customer customer, Inventory inventory, LocalDateTime lastUpdate, LocalDateTime rentalDate, Integer rentalId, LocalDateTime returnDate, Staff staff) {

        this.customer = customer;
        this.inventory = inventory;
        this.lastUpdate = lastUpdate;
        this.rentalDate = rentalDate;
        this.rentalId = rentalId;
        this.returnDate = returnDate;
        this.staff = staff;
    }
}
