package org.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "country", schema = "movie")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Short countryId;
    @Column(name = "country")
    private String country;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Short getCountryId() {
        return countryId;
    }

    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Country() {
    }

    public Country(String country, Short countryId, LocalDateTime lastUpdate) {
        this.country = country;
        this.countryId = countryId;
        this.lastUpdate = lastUpdate;
    }
}
