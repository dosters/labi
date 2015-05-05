package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PersonEntity;
import com.springapp.mvc.domain.PersonmusicEntity;

import java.util.List;

/**
 * Created by Lenovo on 27.03.2015.
 */
public interface PersonDao {
    public int add(PersonEntity person);
    public List<PersonEntity> list();
    public List<PersonEntity> top();
    public PersonEntity getPersonFromId(int id);
    public void changeId(PersonEntity personEntity);
}
