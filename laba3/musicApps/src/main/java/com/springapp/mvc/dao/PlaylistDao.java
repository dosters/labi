package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PersonEntity;
import com.springapp.mvc.domain.PlaylistEntity;

import java.util.List;

/**
 * Created by Lenovo on 28.03.2015.
 */
public interface PlaylistDao {
    public void add(PlaylistEntity playlistEntity);
    public List<PlaylistEntity> getAll();
    public List<PlaylistEntity> top();
    public List<PlaylistEntity>personPlaylists(int id);
    public void like(int idPlaylist,int idPerson);
    public PlaylistEntity getFromId(String name);
    public void delete(int id);
}
