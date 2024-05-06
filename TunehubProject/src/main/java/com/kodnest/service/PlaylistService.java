package com.kodnest.service;

import java.util.List;

import com.kodnest.entity.Playlist;

public interface PlaylistService {

	void addPlaylist(Playlist playlist);

	List<Playlist> fetchAllPlaylists();

	

	

}
