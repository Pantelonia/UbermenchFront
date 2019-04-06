package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;

public class  Visitor {

    private Long id;

    private String status;

    private String nickname;

    private String email;

    private String password;

    @JsonIgnore
    private Collection<Advert> advertsById;

    @JsonIgnore
    private Collection<History> historiesById;

    @JsonIgnore
    private Collection<Playlist> playlistsById;

    @JsonIgnore
    private Collection<PlaylistRate> playlistRatesById;

    @JsonIgnore
    private Collection<Soundtrack> soundtracksById;

    @JsonIgnore
    private Collection<SoundtrackRate> soundtrackRatesById;

    public Visitor() {

    }

    public Visitor(String status, String nickname, String email, String password) {
        this.status = status;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public Visitor(String status, String email) {
        this.status = status;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Advert> getAdvertsById() {
        return advertsById;
    }

    public void setAdvertsById(Collection<Advert> advertsById) {
        this.advertsById = advertsById;
    }

    public Collection<History> getHistoriesById() {
        return historiesById;
    }

    public void setHistoriesById(Collection<History> historiesById) {
        this.historiesById = historiesById;
    }

    public Collection<Playlist> getPlaylistsById() {
        return playlistsById;
    }

    public void setPlaylistsById(Collection<Playlist> playlistsById) {
        this.playlistsById = playlistsById;
    }

    public Collection<PlaylistRate> getPlaylistRatesById() {
        return playlistRatesById;
    }

    public void setPlaylistRatesById(Collection<PlaylistRate> playlistRatesById) {
        this.playlistRatesById = playlistRatesById;
    }

    public Collection<Soundtrack> getSoundtracksById() {
        return soundtracksById;
    }

    public void setSoundtracksById(Collection<Soundtrack> soundtracksById) {
        this.soundtracksById = soundtracksById;
    }

    public Collection<SoundtrackRate> getSoundtrackRatesById() {
        return soundtrackRatesById;
    }

    public void setSoundtrackRatesById(Collection<SoundtrackRate> soundtrackRatesById) {
        this.soundtrackRatesById = soundtrackRatesById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visitor visitor = (Visitor) o;

        if (id != null ? !id.equals(visitor.id) : visitor.id != null) return false;
        if (status != null ? !status.equals(visitor.status) : visitor.status != null) return false;
        if (nickname != null ? !nickname.equals(visitor.nickname) : visitor.nickname != null) return false;
        if (email != null ? !email.equals(visitor.email) : visitor.email != null) return false;
        if (password != null ? !password.equals(visitor.password) : visitor.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
