package com.kodnest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.entity.Playlist;
import com.kodnest.entity.Song;
import com.kodnest.service.PlaylistService;
import com.kodnest.service.SongService;





@Controller
public class PlaylistController {
	@Autowired
	PlaylistService playlistService;
	@Autowired
	SongService songService;
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		List<Song> songlist =songService.fetchAllSongs();
		model.addAttribute("songs",songlist);
		return "createplaylist";
		
	}
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		playlistService.addPlaylist(playlist);
		
		//updating the song_playlists table
		List<Song> songs = playlist.getSongs();
		
		for (Song song : songs) {
			song.getPlaylists().add(playlist);
			songService.updateSong(song);
		}
		
		return "adminhome";
	}
	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<Playlist> allplaylist = playlistService.fetchAllPlaylists();
		
		model.addAttribute("allplaylist", allplaylist);
		return "viewplaylist";
	}
	}
	

