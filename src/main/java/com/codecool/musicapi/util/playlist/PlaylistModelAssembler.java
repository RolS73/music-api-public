package com.codecool.musicapi.util.playlist;

import com.codecool.musicapi.controller.ArtistController;
import com.codecool.musicapi.model.Playlist;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PlaylistModelAssembler implements RepresentationModelAssembler<Playlist, EntityModel<Playlist>> {

    @Override
    public EntityModel<Playlist> toModel(Playlist entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(ArtistController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(ArtistController.class).all()).withRel("playlists")
        );
    }
}
