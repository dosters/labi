package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PersonEntity;
import com.springapp.mvc.domain.PersonmusicEntity;

/**
 * Created by Lenovo on 28.03.2015.
 */
public interface PersonMusicDao {
    public void add(PersonmusicEntity r);
    public void delete(PersonmusicEntity p);
    public void deleteId(int id);
}
