package org.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "address", schema = "movie")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Short addressId;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "address2")
    private String address2;
    @Column(name = "district", nullable = false)
    private String district;
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Short getAddressId() {
        return addressId;
    }

    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Address() {
    }

    public Address(String address2, String address, Short addressId, City city, String district, LocalDateTime lastUpdate, String phone, String postalCode) {
        this.address2 = address2;
        this.address = address;
        this.addressId = addressId;
        this.city = city;
        this.district = district;
        this.lastUpdate = lastUpdate;
        this.phone = phone;
        this.postalCode = postalCode;
    }
}
