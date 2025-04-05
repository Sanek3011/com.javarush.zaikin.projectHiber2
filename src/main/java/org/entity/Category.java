package org.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "category", schema = "movie")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Byte categoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
    @ManyToMany
    @JoinTable(name = "film_category",
    joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"),
    inverseJoinColumns = @JoinColumn(name = "film_id",referencedColumnName = "film_id"))
    private Set<Film> films;

    public Byte getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Byte categoryId) {
        this.categoryId = categoryId;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(Byte categoryId, Set<Film> films, LocalDateTime lastUpdate, String name) {
        this.categoryId = categoryId;
        this.films = films;
        this.lastUpdate = lastUpdate;
        this.name = name;
    }

    public Category() {
    }
}
