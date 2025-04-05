package org.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "film_text", schema = "movie")
public class FilmText {
    @Id
    @Column(name = "film_id")
    private Short filmId;
    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FilmText() {
    }

    public FilmText(String description, Film film, Short filmId, String title) {
        this.description = description;
        this.film = film;
        this.filmId = filmId;
        this.title = title;
    }
}
