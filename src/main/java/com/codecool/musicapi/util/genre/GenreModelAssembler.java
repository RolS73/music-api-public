package com.codecool.musicapi.util.genre;

import com.codecool.musicapi.controller.ArtistController;
import com.codecool.musicapi.model.Genre;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GenreModelAssembler implements RepresentationModelAssembler<Genre, EntityModel<Genre>> {

    @Override
    public EntityModel<Genre> toModel(Genre entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(ArtistController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(ArtistController.class).all()).withRel("genres")
        );
    }
}
