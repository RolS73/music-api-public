package com.codecool.musicapi.controller;

import com.codecool.musicapi.model.DTO.SongDTO;
import com.codecool.musicapi.service.SongService;
import com.codecool.musicapi.util.song.SongModelAssembler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/songs")
public class SongController {

    SongService songService;
    SongModelAssembler assembler;

    public SongController(SongService songService, SongModelAssembler assembler) {
        this.songService = songService;
        this.assembler = assembler;
    }

    @PostMapping
    public void addNew(@RequestBody SongDTO SongDTO) {
        songService.addNew(SongDTO);
    }

    @GetMapping
    public List<SongDTO> listAll() {
        return songService.listAll();
    }

    @GetMapping(value = "/{id}")
    public SongDTO findById(@PathVariable Long id) {
        return songService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@RequestBody SongDTO newData,@PathVariable Long id) {
        songService.update(newData, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        songService.delete(id);
    }
}
