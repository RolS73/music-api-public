package com.codecool.musicapi.service;

import com.codecool.musicapi.model.DTO.DTFactory.SongDTFactory;
import com.codecool.musicapi.model.DTO.SongDTO;
import com.codecool.musicapi.model.Song;
import com.codecool.musicapi.repository.SongRepository;
import com.codecool.musicapi.util.LoggerUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository repository;
    private final SongDTFactory dtFactory;

    public SongService(SongRepository repository, SongDTFactory dtFactory) {
        this.repository = repository;
        this.dtFactory = dtFactory;
    }

    public void addNew(SongDTO songDTO) {
        LoggerUtil.log.info("Adding new song object to DB: " + songDTO.toString());

        repository.save(dtFactory.POJOFromDTO(songDTO));
    }

    public List<SongDTO> listAll() {
        LoggerUtil.log.info("Retrieving all song entries from DB");

        return dtFactory.ListDTOFromList(repository.findAll());
    }

    public SongDTO findById(Long id) {
        LoggerUtil.log.info("Retrieving song with id: " + id);

        Song song = repository.findById(id).orElse(null);
        if (song != null) {
            return dtFactory.DTOFromPOJO(song);
        } else {
            return null;
        }
    }

    public void update(SongDTO newData, Long id) {
        LoggerUtil.log.info("Updating album with id: " + id + "with data: " + newData.toString());

        Song pojoData = dtFactory.POJOFromDTO(newData);
        pojoData.setId(id);
        repository.save(pojoData);
        /*repository.findById(id).stream()
                .map(song -> {
                    song.setName(newData.getName());
                    song.setArtist(newData.getArtist());
                    return repository.save(song);
                });*/
    }

    public void delete(Long id) {
        LoggerUtil.log.info("Deleting album entry from database with id: " + id);

        repository.deleteById(id);
    }

}
