package com.springapp.mvc.service;

import com.springapp.mvc.dao.MusiclikedpersonDao;
import com.springapp.mvc.domain.MusiclikedpersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 13.04.2015.
 */
public class MusiclikedPersonServiceImpl implements MusiclikedPersonService {
    @Autowired
    private MusiclikedpersonDao musiclikedpersonDao;
    @Transactional
    @Override
    public void add(int idMusic, int idPerson) {
        musiclikedpersonDao.add(idMusic,idPerson);
    }
    @Transactional
    @Override
    public List<MusiclikedpersonEntity> getAll() {
        return musiclikedpersonDao.getAll();
    }
    @Transactional
    @Override
    public void delete(int idMusic) {
        musiclikedpersonDao.delete(idMusic);
    }
}
