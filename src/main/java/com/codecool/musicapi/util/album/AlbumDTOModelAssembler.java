package com.codecool.musicapi.util.album;

import com.codecool.musicapi.controller.ArtistController;
import com.codecool.musicapi.model.DTO.AlbumDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AlbumDTOModelAssembler implements RepresentationModelAssembler<AlbumDTO, EntityModel<AlbumDTO>> {

    @Override
    public EntityModel<AlbumDTO> toModel(AlbumDTO entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(ArtistController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(ArtistController.class).all()).withRel("albums")
        );
    }

}
