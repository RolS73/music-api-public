package com.codecool.musicapi.service;

import com.codecool.musicapi.controller.ArtistController;
import com.codecool.musicapi.model.Artist;
import com.codecool.musicapi.model.DTO.ArtistDTO;
import com.codecool.musicapi.model.DTO.DTFactory.ArtistDTFactory;
import com.codecool.musicapi.repository.ArtistRepository;
import com.codecool.musicapi.util.LoggerUtil;
import com.codecool.musicapi.util.artist.ArtistDTOModelAssembler;
import com.codecool.musicapi.util.artist.ArtistModelAssembler;
import com.codecool.musicapi.util.artist.ArtistNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ArtistService {

    private final ArtistRepository repository;
    private final ArtistDTFactory artistDTFactory;
    private final ArtistModelAssembler assembler;
    private final ArtistDTOModelAssembler dtoAssembler;

    public ArtistService(ArtistRepository repository, ArtistDTFactory artistDTFactory, ArtistModelAssembler assembler, ArtistDTOModelAssembler dtoAssembler) {
        this.repository = repository;
        this.artistDTFactory = artistDTFactory;
        this.assembler = assembler;
        this.dtoAssembler = dtoAssembler;
    }

    public ResponseEntity<?> newArtist(ArtistDTO newArtist) {
        LoggerUtil.log.info("Adding new artist object to DB: " + newArtist.toString());
        EntityModel<Artist> artistEntityModel = assembler.toModel(repository.save(artistDTFactory.POJOFromDTO(newArtist)));

        return ResponseEntity
                .created(artistEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(artistEntityModel);
    }

    public CollectionModel<EntityModel<ArtistDTO>> all() {
        LoggerUtil.log.info("Retrieving all artist entries from DB");
        List<EntityModel<ArtistDTO>> artists = repository.findAll().stream()
                .map(artistDTFactory::DTOFromPOJO)
                .map(dtoAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(artists,
                linkTo(methodOn(ArtistController.class).all()).withSelfRel());

    }


    public EntityModel<ArtistDTO> one(Long id) {
        LoggerUtil.log.info("Retrieving artist with id: " + id);

        Artist artist = repository.findById(id).orElseThrow(() -> new ArtistNotFoundException(id));

        return dtoAssembler.toModel(artistDTFactory.DTOFromPOJO(artist));
    }


    public ResponseEntity<?> replaceArtist(ArtistDTO newArtist,Long id) {
        LoggerUtil.log.info("Updating artist with id: " + id + "with data: " + newArtist.getName());

        Artist updatedArtist = repository.findById(id)
                .map(artist -> {
                    artist.setName(newArtist.getName());
                    return repository.save(artist);
                }).orElseGet(() -> {
                    newArtist.setId(id);
                    return repository.save(artistDTFactory.POJOFromDTO(newArtist));
                });

        EntityModel<Artist> entityModel = assembler.toModel(updatedArtist);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }


    public ResponseEntity<?> deleteArtist(Long id) {
        LoggerUtil.log.info("Deleting artist entry from database with id: " + id);

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
