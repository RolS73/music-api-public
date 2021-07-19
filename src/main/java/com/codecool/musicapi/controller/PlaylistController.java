package com.codecool.musicapi.controller;

import com.codecool.musicapi.model.DTO.PlaylistDTO;
import com.codecool.musicapi.model.DTO.SongDTO;
import com.codecool.musicapi.service.PlaylistService;
import com.codecool.musicapi.util.playlist.PlaylistModelAssembler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/playlists")
public class PlaylistController {

    PlaylistService playlistService;
    PlaylistModelAssembler assembler;

    public PlaylistController(PlaylistService playlistService, PlaylistModelAssembler assembler) {
        this.playlistService = playlistService;
        this.assembler = assembler;
    }


    @PostMapping
    public void addNew(@RequestBody PlaylistDTO PlaylistDTO) {
        playlistService.addNew(PlaylistDTO);
    }

    @GetMapping
    public List<PlaylistDTO> listAll() {
        return playlistService.listAll();
    }

    @GetMapping(value = "/{id}")
    public PlaylistDTO findById(@PathVariable Long id) {
        return playlistService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@RequestBody PlaylistDTO newData,@PathVariable Long id) {
        playlistService.update(newData, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        playlistService.delete(id);
    }

    @GetMapping(value = "/{id}/songs")
    public List<SongDTO> getSongsFromPlaylistWithId(@PathVariable Long id) {
        return playlistService.getSongsFromPlaylistWithId(id);
    }

    @GetMapping(value = "/{playlist_id}/songs/{id}")
    public SongDTO getSongWithIdFromPlaylistWithId(@PathVariable("playlist_id") Long genreId, @PathVariable Long id) {
        return playlistService.getSongWithIdFromPlaylistWithId(genreId, id);
    }
}
