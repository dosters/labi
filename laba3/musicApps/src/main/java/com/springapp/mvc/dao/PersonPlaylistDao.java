package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PersonmusicEntity;
import com.springapp.mvc.domain.PersonplaylistEntity;

/**
 * Created by Lenovo on 28.03.2015.
 */
public interface PersonPlaylistDao {
    public void add(int idPerson,int idPlaylist);
    public void delete(PersonplaylistEntity p);
    public void deleteID(int id);
}
