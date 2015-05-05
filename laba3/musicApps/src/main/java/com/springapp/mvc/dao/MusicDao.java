package com.springapp.mvc.dao;

import com.springapp.mvc.domain.MusicEntity;
import com.springapp.mvc.domain.PlaylistEntity;

import java.util.List;

public interface MusicDao {
public void add(MusicEntity musicEntity);
    public List<MusicEntity> getAllMusic();
    public List<MusicEntity> top();
    public List<MusicEntity> getMusic(int id);
    public void like(int idMusic,int idPerson);
    public List<MusicEntity> playlistMusic(int idPlaylist);
    public List<MusicEntity> search(String s);
    public void delete(int id);
}
