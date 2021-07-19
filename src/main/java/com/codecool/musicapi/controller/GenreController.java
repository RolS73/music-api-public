package com.codecool.musicapi.controller;

import com.codecool.musicapi.model.DTO.GenreDTO;
import com.codecool.musicapi.model.DTO.SongDTO;
import com.codecool.musicapi.service.GenreService;
import com.codecool.musicapi.util.genre.GenreModelAssembler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

    GenreService genreService;
    GenreModelAssembler assembler;

    public GenreController(GenreService genreService, GenreModelAssembler assembler) {
        this.genreService = genreService;
        this.assembler = assembler;
    }

    @PostMapping
    public void addNew(@RequestBody GenreDTO GenreDTO) {
        genreService.addNew(GenreDTO);
    }

    @GetMapping
    public List<GenreDTO> listAll() {
        return genreService.listAll();
    }

    @GetMapping(value = "/{id}")
    public GenreDTO findById(@PathVariable Long id) {
        return genreService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@RequestBody GenreDTO newData,@PathVariable Long id) {
        genreService.update(newData, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        genreService.delete(id);
    }

    @GetMapping(value = "/{id}/songs")
    public List<SongDTO> getSongsFromGenreWithId(@PathVariable Long id) {
        return genreService.getSongsFromGenreWithId(id);
    }

    @GetMapping(value = "/{genre_id}/songs/{id}")
    public SongDTO getSongWithIdFromAlbumWithId(@PathVariable("genre_id") Long genreId, @PathVariable Long id) {
        return genreService.getSongWithIdFromAlbumWithId(genreId, id);
    }
}
