package com.codecool.musicapi.util.album;

import com.codecool.musicapi.controller.ArtistController;
import com.codecool.musicapi.model.Album;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AlbumModelAssembler implements RepresentationModelAssembler<Album, EntityModel<Album>> {

    @Override
    public EntityModel<Album> toModel(Album entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(ArtistController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(ArtistController.class).all()).withRel("albums")
        );
    }

}
