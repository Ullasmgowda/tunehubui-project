package com.kodnest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.entity.Playlist;
import com.kodnest.repository.PlaylistRepository;
import com.kodnest.service.PlaylistService;
@Service
public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addPlaylist(Playlist playlist) {
		playlistRepository.save(playlist);	
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		List<Playlist> allplaylist=playlistRepository.findAll();
		return allplaylist;
	}
	
}
