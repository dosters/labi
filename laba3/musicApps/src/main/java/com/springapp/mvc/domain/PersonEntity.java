package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Lenovo on 02.04.2015.
 */
@Entity
@Table(name = "person", schema = "", catalog = "musics")
public class PersonEntity {
    private int id;
    private String lastName;
    private String name;
    private Collection<PersonmusicEntity> personmusicsById;
    private Collection<PersonplaylistEntity> personplaylistsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (id != that.id) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personByIdPerson")
    public Collection<PersonmusicEntity> getPersonmusicsById() {
        return personmusicsById;
    }

    public void setPersonmusicsById(Collection<PersonmusicEntity> personmusicsById) {
        this.personmusicsById = personmusicsById;
    }

    @OneToMany(mappedBy = "personByIdPerson")
    public Collection<PersonplaylistEntity> getPersonplaylistsById() {
        return personplaylistsById;
    }

    public void setPersonplaylistsById(Collection<PersonplaylistEntity> personplaylistsById) {
        this.personplaylistsById = personplaylistsById;
    }
}
