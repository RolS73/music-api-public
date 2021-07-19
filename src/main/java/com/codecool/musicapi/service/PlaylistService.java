package com.codecool.musicapi.service;

import com.codecool.musicapi.model.DTO.DTFactory.PlaylistDTFactory;
import com.codecool.musicapi.model.DTO.DTFactory.SongDTFactory;
import com.codecool.musicapi.model.DTO.PlaylistDTO;
import com.codecool.musicapi.model.DTO.SongDTO;
import com.codecool.musicapi.model.Playlist;
import com.codecool.musicapi.repository.PlaylistRepository;
import com.codecool.musicapi.repository.SongRepository;
import com.codecool.musicapi.util.LoggerUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    PlaylistRepository repository;
    SongRepository songRepository;
    PlaylistDTFactory dtFactory;
    SongDTFactory songDTFactory;

    public PlaylistService(PlaylistRepository repository, SongRepository songRepository, PlaylistDTFactory dtFactory, SongDTFactory songDTFactory) {
        this.repository = repository;
        this.songRepository = songRepository;
        this.dtFactory = dtFactory;
        this.songDTFactory = songDTFactory;
    }

    public void addNew(PlaylistDTO playlistDTO) {
        LoggerUtil.log.info("Adding new playlist object to DB: " + playlistDTO.toString());

        repository.save(dtFactory.POJOFromDTO(playlistDTO));
    }

    public List<PlaylistDTO> listAll() {
        LoggerUtil.log.info("Retrieving all playlist entries from DB");

        return dtFactory.ListDTOFromList(repository.findAll());
    }

    public PlaylistDTO findById(Long id) {
        LoggerUtil.log.info("Retrieving playlist with id: " + id);

        Playlist playlist = repository.findById(id).orElse(null);
        if (playlist != null) {
            return dtFactory.DTOFromPOJO(playlist);
        } else {
            return null;
        }
    }

    public void update(PlaylistDTO newData, Long id) {
        LoggerUtil.log.info("Updating album with id: " + id + "with data: " + newData.getPlaylistName());

        Playlist pojoData = dtFactory.POJOFromDTO(newData);
        pojoData.setId(id);
        repository.save(pojoData);
        /*repository.findById(id).stream()
                .map(playlist -> {
                    playlist.setPlaylistName(newData.getPlaylistName());
                    return repository.save(playlist);
                });*/
    }

    public void delete(Long id) {
        LoggerUtil.log.info("Deleting playlist entry from database with id: " + id);

        repository.deleteById(id);
    }


    public List<SongDTO> getSongsFromPlaylistWithId(Long id) {
        LoggerUtil.log.info("Retrieving all songs with playlist id: " + id);

        return songDTFactory.ListDTOFromList(songRepository.getSongsByPlaylistId(id));
    }

    public SongDTO getSongWithIdFromPlaylistWithId(Long genreId, Long id) {
        LoggerUtil.log.info("Retrieving song with id: " + id + "from playlist with id: " + genreId);

        return songDTFactory.DTOFromPOJO(songRepository.getSongByIdFromPlaylist(genreId, id));
    }
}
