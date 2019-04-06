package com.pokorili.musicOn.entity;

public class PlaylistSoundtrack {

    private Long id;

    private Playlist playlist;

    private Soundtrack soundtrack;

    public PlaylistSoundtrack() {}

    public PlaylistSoundtrack(Playlist playlist, Soundtrack soundtrack) {
        this.playlist = playlist;
        this.soundtrack =soundtrack;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Soundtrack getSoundtrack() {
        return soundtrack;
    }

    public void setSoundtrack(Soundtrack soundtrack) {
        this.soundtrack = soundtrack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaylistSoundtrack that = (PlaylistSoundtrack) o;

        if (playlist != null ? !playlist.equals(that.playlist) : that.playlist != null) return false;
        if (soundtrack != null ? !soundtrack.equals(that.soundtrack) : that.soundtrack != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playlist != null ? playlist.hashCode() : 0;
        result = 31 * result + (soundtrack != null ? soundtrack.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
