package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by Lenovo on 02.04.2015.
 */
@Entity
@Table(name = "playlistmusic", schema = "", catalog = "musics")
public class PlaylistmusicEntity {
    private int id;
    private Integer idPlaylist;
    private Integer idMusic;
    private MusicEntity musicByIdMusic;
    private PlaylistEntity playlistByIdPlaylist;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlaylistmusicEntity(Integer idPlaylist, Integer idMusic) {
        this.idPlaylist = idPlaylist;
        this.idMusic = idMusic;
    }

    public PlaylistmusicEntity() {
    }

    @Basic

    @Column(name = "idPlaylist",insertable = false,updatable = false)
    public Integer getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    @Basic
    @Column(name = "idMusic",insertable = false,updatable = false)
    public Integer getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(int idMusic) {
        this.idMusic = idMusic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaylistmusicEntity that = (PlaylistmusicEntity) o;

        if (id != that.id) return false;
        if (idPlaylist != that.idPlaylist) return false;
        if (idMusic != that.idMusic) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idPlaylist;
        result = 31 * result + idMusic;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idMusic", referencedColumnName = "id", nullable = false)
    public MusicEntity getMusicByIdMusic() {
        return musicByIdMusic;
    }

    public void setMusicByIdMusic(MusicEntity musicByIdMusic) {
        this.musicByIdMusic = musicByIdMusic;
    }

    @ManyToOne
    @JoinColumn(name = "idPlaylist", referencedColumnName = "id", nullable = false)
    public PlaylistEntity getPlaylistByIdPlaylist() {
        return playlistByIdPlaylist;
    }

    public void setPlaylistByIdPlaylist(PlaylistEntity playlistByIdPlaylist) {
        this.playlistByIdPlaylist = playlistByIdPlaylist;
    }
}
