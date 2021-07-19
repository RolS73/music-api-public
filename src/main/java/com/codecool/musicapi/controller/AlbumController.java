package com.codecool.musicapi.controller;

import com.codecool.musicapi.model.DTO.AlbumDTO;
import com.codecool.musicapi.model.DTO.SongDTO;
import com.codecool.musicapi.service.AlbumService;
import com.codecool.musicapi.util.album.AlbumModelAssembler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final AlbumModelAssembler assembler;

    public AlbumController(AlbumService albumService, AlbumModelAssembler assembler) {
        this.albumService = albumService;
        this.assembler = assembler;
    }

    @PostMapping
    public void addNew(@RequestBody AlbumDTO albumDTO) {
        albumService.addNew(albumDTO);
    }

    @GetMapping
    public List<AlbumDTO> listAll() {
        return albumService.listAll();
    }

    @GetMapping(value = "/{id}")
    public AlbumDTO findById(@PathVariable Long id) {
        return albumService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@RequestBody AlbumDTO newData,@PathVariable Long id) {
        albumService.update(newData, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        albumService.delete(id);
    }

    @GetMapping(value = "/{id}/songs")
    public List<SongDTO> getSongsFromAlbumWithId(@PathVariable Long id) {
        return albumService.getSongsFromAlbumWithId(id);
    }

    @GetMapping(value = "/{album_id}/songs/{id}")
    public SongDTO getSongWithIdFromAlbumWithId(@PathVariable("album_id") Long genreId,@PathVariable Long id) {
        return albumService.getSongWithIdFromAlbumWithId(genreId, id);
    }
}
