package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PlaylistmusicEntity;

/**
 * Created by Lenovo on 28.03.2015.
 */
public interface PlaylistMusicDao {
    public void add(int idMusic,int idPlaylist);
    public void delete(int idMusic,int idPlaylist);
    public void deleteMP(int idMusic);
    public void deleteID(int idMusic);
    public void deleteIdP(int idPlaylist);
}
