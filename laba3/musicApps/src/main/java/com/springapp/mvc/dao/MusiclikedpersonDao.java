package com.springapp.mvc.dao;

import com.springapp.mvc.domain.MusiclikedpersonEntity;

import java.util.List;

/**
 * Created by Lenovo on 06.04.2015.
 */
public interface MusiclikedpersonDao {
    public void add(int idMusic,int idPerson);
    public List<MusiclikedpersonEntity> getAll();
    public void delete(int idMusic);
}
