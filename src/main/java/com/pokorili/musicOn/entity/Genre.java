package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Genre {

    private Long id;

    private String title;

    private Genre parentGenre;

    @JsonIgnore
    private Collection<Genre> genresById;

    @JsonIgnore
    private Collection<Soundtrack> soundtracksById;


    public Genre(String title, Genre genre) {
        this.title = title;
        this.parentGenre = genre;
    }

    public Genre() {

    }

    public Genre(String title) {
        this.title = title;
    }

    public Genre(Long id, String title, Genre parentGenre) {
        this.id = id;
        this.title = title;
        this.parentGenre = parentGenre;
    }
    public Genre(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getParentGenre() {
        return parentGenre;
    }

    public void setParentGenre(Genre genreByGenreId) {
        this.parentGenre = genreByGenreId;
    }

    public Collection<Genre> getGenresById() {
        return genresById;
    }

    public void setGenresById(Collection<Genre> genresById) {
        this.genresById = genresById;
    }

    public Collection<Soundtrack> getSoundtracksById() {
        return soundtracksById;
    }

    public void setSoundtracksById(Collection<Soundtrack> soundtracksById) {
        this.soundtracksById = soundtracksById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != null ? !id.equals(genre.id) : genre.id != null) return false;
        if (title != null ? !title.equals(genre.title) : genre.title != null) return false;
        if (parentGenre != null ? !parentGenre.equals(genre.parentGenre) : genre.parentGenre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (parentGenre != null ? parentGenre.hashCode() : 0);
        return result;
    }
}
