package com.springapp.mvc.domain;

import javax.persistence.*;
@Entity
@Table(name = "musiclikedperson", schema = "", catalog = "musics")
public class MusiclikedpersonEntity {
    private int id;
    private int idPerson;
    private int idMusic;
    private MusicEntity musicByIdMusic;
    private PersonEntity personByIdPerson;

    @Id
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

    @Basic
    @Column(name = "idMusic",insertable = false,updatable = false)
    public int getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(int idMusic) {
        this.idMusic = idMusic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusiclikedpersonEntity that = (MusiclikedpersonEntity) o;

        if (id != that.id) return false;
        if (idPerson != that.idPerson) return false;
        if (idMusic != that.idMusic) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idPerson;
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
    @JoinColumn(name = "idPerson", referencedColumnName = "id", nullable = false)
    public PersonEntity getPersonByIdPerson() {
        return personByIdPerson;
    }

    public void setPersonByIdPerson(PersonEntity personByIdPerson) {
        this.personByIdPerson = personByIdPerson;
    }
}
