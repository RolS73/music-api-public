package com.codecool.musicapi.util.song;

import com.codecool.musicapi.controller.ArtistController;
import com.codecool.musicapi.model.Song;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SongModelAssembler implements RepresentationModelAssembler<Song, EntityModel<Song>> {

    @Override
    public EntityModel<Song> toModel(Song entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(ArtistController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(ArtistController.class).all()).withRel("songs")
        );
    }
}
