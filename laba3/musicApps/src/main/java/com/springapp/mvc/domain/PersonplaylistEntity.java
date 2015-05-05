package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by Lenovo on 02.04.2015.
 */
@Entity
@Table(name = "personplaylist", schema = "", catalog = "musics")
public class PersonplaylistEntity {
    private int id;
    private int idPerson;
    private int idPlaylist;
    private PlaylistEntity playlistByIdPlaylist;
    private PersonEntity personByIdPerson;

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
    @Column(name = "idPerson",insertable = false,updatable = false)
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public PersonplaylistEntity(int idPerson, int idPlaylist) {
        this.idPerson = idPerson;
        this.idPlaylist = idPlaylist;
    }

    @Basic
    @Column(name = "idPlaylist",insertable = false,updatable = false)
    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public PersonplaylistEntity() {
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonplaylistEntity that = (PersonplaylistEntity) o;

        if (id != that.id) return false;
        if (idPerson != that.idPerson) return false;
        if (idPlaylist != that.idPlaylist) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idPerson;
        result = 31 * result + idPlaylist;
        return result;
    }
    @ManyToOne
    @JoinColumn(name = "idPlaylist", referencedColumnName = "id", nullable = false)
    public PlaylistEntity getPlaylistByIdPlaylist() {
        return playlistByIdPlaylist;
    }

    public void setPlaylistByIdPlaylist(PlaylistEntity playlistByIdPlaylist) {
        this.playlistByIdPlaylist = playlistByIdPlaylist;
    }

    @ManyToOne
    @JoinColumn(name = "idPerson", referencedColumnName = "id", nullable = false)
    public PersonEntity getPersonByIdPerson() {
        return personByIdPerson;
    }

    public void setPersonByIdPerson(PersonEntity personByIdPerson) {
        this.personByIdPerson = personByIdPerson;
    }
}
