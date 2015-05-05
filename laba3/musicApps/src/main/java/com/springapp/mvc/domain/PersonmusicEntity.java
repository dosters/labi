package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by Lenovo on 02.04.2015.
 */
@Entity
@Table(name = "personmusic", schema = "", catalog = "musics")
public class PersonmusicEntity {
    private int id;
    private Integer idMusic;
    private Integer idPerson;
    private PersonEntity personByIdPerson;
    private MusicEntity musicByIdMusic;

    public PersonmusicEntity() {
    }

    public PersonmusicEntity(int idMusic, int idPerson) {
        this.idMusic = idMusic;
        this.idPerson = idPerson;
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
    @Column(name = "idMusic",insertable = false,updatable = false)
    public Integer getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(int idMusic) {
        this.idMusic = idMusic;
    }

    @Basic
    @Column(name = "idPerson",insertable = false,updatable = false)
    public Integer getIdPerson() {
        return idPerson;
    }
    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonmusicEntity that = (PersonmusicEntity) o;

        if (id != that.id) return false;
        if (idMusic != that.idMusic) return false;
        if (idPerson != that.idPerson) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idMusic;
        result = 31 * result + idPerson;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idPerson", referencedColumnName = "id", nullable = false)
    public PersonEntity getPersonByIdPerson() {
        return personByIdPerson;
    }

    public void setPersonByIdPerson(PersonEntity personByIdPerson) {
        this.personByIdPerson = personByIdPerson;
    }

    @ManyToOne
    @JoinColumn(name = "idMusic", referencedColumnName = "id", nullable = false)
    public MusicEntity getMusicByIdMusic() {
        return musicByIdMusic;
    }

    public void setMusicByIdMusic(MusicEntity musicByIdMusic) {
        this.musicByIdMusic = musicByIdMusic;
    }
}
