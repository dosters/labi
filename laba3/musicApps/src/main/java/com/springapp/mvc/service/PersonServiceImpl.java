package com.springapp.mvc.service;

import com.springapp.mvc.dao.PersonDao;
import com.springapp.mvc.domain.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 27.03.2015.
 */
@Service
public class PersonServiceImpl implements PersonService  {

    @Autowired
    private PersonDao personDao;
    @Override
    @Transactional
    public int add(PersonEntity person) {
    return personDao.add(person);
    }
    @Transactional
    @Override
    public List<PersonEntity> list() {
        return personDao.list();
    }
    @Transactional
    @Override
    public List<PersonEntity> top() {
        return personDao.top();
    }
    @Transactional
    @Override
    public PersonEntity getPersonFromId(int id) {
        return personDao.getPersonFromId(id);
    }

    @Transactional
    @Override
    public void changeId(PersonEntity personEntity) {
    personDao.changeId(personEntity);
    }
}
