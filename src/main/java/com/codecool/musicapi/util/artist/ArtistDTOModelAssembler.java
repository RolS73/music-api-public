package com.codecool.musicapi.util.artist;

import com.codecool.musicapi.controller.ArtistController;
import com.codecool.musicapi.model.DTO.ArtistDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ArtistDTOModelAssembler implements RepresentationModelAssembler<ArtistDTO, EntityModel<ArtistDTO>> {

    @Override
    public EntityModel<ArtistDTO> toModel(ArtistDTO entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(ArtistController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(ArtistController.class).all()).withRel("artists")
                );
    }
}
