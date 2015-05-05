package com.springapp.mvc.service;

import com.springapp.mvc.dao.PersonMusicDao;
import com.springapp.mvc.domain.PersonEntity;
import com.springapp.mvc.domain.PersonmusicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class PersonMusicServiceImpl implements PersonMusicService {
    @Autowired
    private PersonMusicDao personMusicDao;
    @Override
    @Transactional
    public void add(PersonmusicEntity personEntity) {
        personMusicDao.add(personEntity);
    }
    @Transactional
    @Override
    public void delete(PersonmusicEntity p) {
        personMusicDao.delete(p);
    }
    @Transactional
    @Override
    public void deleteId(int id) {
        personMusicDao.deleteId(id);
    }
}
