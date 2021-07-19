package com.codecool.musicapi.controller;

import com.codecool.musicapi.model.DTO.ArtistDTO;
import com.codecool.musicapi.service.ArtistService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/artists")
public class ArtistController {

    /*private final ArtistRepository repository;
    private final ArtistModelAssembler assembler;*/

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public CollectionModel<EntityModel<ArtistDTO>> all() {
       return artistService.all();
    }

    @PostMapping
    ResponseEntity<?> newArtist(@RequestBody ArtistDTO newArtist) {
        return artistService.newArtist(newArtist);
    }

    @GetMapping(value = "/{id}")
    public EntityModel<ArtistDTO> one(@PathVariable Long id) {
        return artistService.one(id);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<?> replaceArtist(@RequestBody ArtistDTO newArtist, @PathVariable Long id) {
       return artistService.replaceArtist(newArtist, id);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);

        return ResponseEntity.noContent().build();
    }
}
