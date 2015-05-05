package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Lenovo on 02.04.2015.
 */
@Entity
@Table(name = "music", schema = "", catalog = "musics")
public class MusicEntity {
    private int id;
    private String cind;
    private Integer likes;
    private String name;
    private String scr;
    private Collection<PersonmusicEntity> personmusicsById;
    private Collection<PlaylistmusicEntity> playlistmusicsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "likes")
    public Integer getLikes() {
        return likes;
    }

    public MusicEntity(Integer likes, String name, String scr) {
        this.likes = likes;
        this.name = name;
        this.scr = scr;
    }

    public MusicEntity() {
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
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
    @Column(name = "scr")
    public String getScr() {
        return scr;
    }

    public void setScr(String scr) {
        this.scr = scr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicEntity that = (MusicEntity) o;

        if (id != that.id) return false;
        if (cind != null ? !cind.equals(that.cind) : that.cind != null) return false;
        if (likes != null ? !likes.equals(that.likes) : that.likes != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (scr != null ? !scr.equals(that.scr) : that.scr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cind != null ? cind.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (scr != null ? scr.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "musicByIdMusic")
    public Collection<PersonmusicEntity> getPersonmusicsById() {
        return personmusicsById;
    }

    public void setPersonmusicsById(Collection<PersonmusicEntity> personmusicsById) {
        this.personmusicsById = personmusicsById;
    }

    @OneToMany(mappedBy = "musicByIdMusic")
    public Collection<PlaylistmusicEntity> getPlaylistmusicsById() {
        return playlistmusicsById;
    }

    public void setPlaylistmusicsById(Collection<PlaylistmusicEntity> playlistmusicsById) {
        this.playlistmusicsById = playlistmusicsById;
    }
}
