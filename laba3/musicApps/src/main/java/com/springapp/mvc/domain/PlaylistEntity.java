package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Lenovo on 02.04.2015.
 */
@Entity
@Table(name = "playlist", schema = "", catalog = "musics")
public class PlaylistEntity {
    private int id;
    private String name;
    private Integer likes;
    private Collection<PersonplaylistEntity> personplaylistsById;
    private Collection<PlaylistmusicEntity> playlistmusicsById;

    public PlaylistEntity(String name) {
        this.name = name;
    }

    public PlaylistEntity() {
    }

    @Id
    @GeneratedValue
    @Column(name = "id")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "likes")
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaylistEntity that = (PlaylistEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "playlistByIdPlaylist")
    public Collection<PersonplaylistEntity> getPersonplaylistsById() {
        return personplaylistsById;
    }

    public void setPersonplaylistsById(Collection<PersonplaylistEntity> personplaylistsById) {
        this.personplaylistsById = personplaylistsById;
    }

    @OneToMany(mappedBy = "playlistByIdPlaylist")
    public Collection<PlaylistmusicEntity> getPlaylistmusicsById() {
        return playlistmusicsById;
    }

    public void setPlaylistmusicsById(Collection<PlaylistmusicEntity> playlistmusicsById) {
        this.playlistmusicsById = playlistmusicsById;
    }
}
