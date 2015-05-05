package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PlaylistlikedpersonEntity;

import java.util.List;

/**
 * Created by Lenovo on 06.04.2015.
 */
public interface PlaylistlikedpersonDao {
    public void add(int idPlaylist,int idPerson);
    public List<PlaylistlikedpersonEntity> getall();
    public void delete(int idPlaylist);
}
