package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by Lenovo on 06.04.2015.
 */
@Entity
@Table(name = "playlistlikedperson", schema = "", catalog = "musics")
public class PlaylistlikedpersonEntity {
    private int id;
    private int idPlaylist;
    private int idPerson;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idPlaylist",insertable = false,updatable = false)
    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    @Basic
    @Column(name = "idPerson",insertable = false,updatable = false)
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaylistlikedpersonEntity that = (PlaylistlikedpersonEntity) o;

        if (id != that.id) return false;
        if (idPlaylist != that.idPlaylist) return false;
        if (idPerson != that.idPerson) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idPlaylist;
        result = 31 * result + idPerson;
        return result;
    }
}
