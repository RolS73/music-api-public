package com.codecool.musicapi.configuration;

import com.codecool.musicapi.model.*;
import com.codecool.musicapi.repository.*;
import com.codecool.musicapi.util.LoggerUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class LoadDatabase {

    //private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    List<Playlist> initialPlaylists = Arrays.asList(new Playlist("Big Boomers"), new Playlist("Bold Bangers"));
    List<Artist> initialArtists = Arrays.asList(new Artist("Mika James"), new Artist("MC Hatter"));
    List<Genre> initialGenre = Arrays.asList(new Genre("Soul"), new Genre("Rap"));
    List<Album> initialAlbums = Arrays.asList(new Album("Mika's Magic"), new Album("Streets of LA"));

    @Bean
    CommandLineRunner initDatabaseArtistEntries(ArtistRepository artistRepository) {
        return args -> {
            LoggerUtil.log.info("Preloading " + artistRepository.save(initialArtists.get(0)) + "\n");
            LoggerUtil.log.info("Preloading " + artistRepository.save(initialArtists.get(1)) + "\n");
        };
    }

    @Bean
    CommandLineRunner initDatabaseAlbumEntries(AlbumRepository repository) {
        return args -> {
            LoggerUtil.log.info("Preloading " + repository.save(initialAlbums.get(0)) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(initialAlbums.get(1)) + "\n");
        };
    }

    @Bean
    CommandLineRunner initDatabaseGenreEntries(GenreRepository repository) {
        return args -> {
            LoggerUtil.log.info("Preloading " + repository.save(initialGenre.get(0)) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(initialGenre.get(1)) + "\n");
        };
    }

    @Bean
    CommandLineRunner initDatabasePlaylistEntries(PlaylistRepository repository) {
        return args -> {
            LoggerUtil.log.info("Preloading " + repository.save(initialPlaylists.get(0)) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(initialPlaylists.get(1)) + "\n");
        };
    }

    @Bean
    CommandLineRunner initDatabaseSongEntries(SongRepository repository) {
        return args -> {
            LoggerUtil.log.info("Preloading " + repository.save(new Song("Scream And Get Money",
                    initialAlbums.get(0),
                    initialArtists.get(0),
                    initialPlaylists.get(0),
                    initialGenre.get(0)
            )) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(new Song("Love Me Baby Day And Night",
                    initialAlbums.get(0),
                    initialArtists.get(0),
                    initialPlaylists.get(0),
                    initialGenre.get(0)
            )) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(new Song("You are the sweetest, honey",
                    initialAlbums.get(0),
                    initialArtists.get(0),
                    initialPlaylists.get(0),
                    initialGenre.get(0)
            ))+ "\n");
            LoggerUtil.log.info("Preloading " + repository.save(new Song("Lamborghini Love",
                    initialAlbums.get(0),
                    initialArtists.get(0),
                    initialPlaylists.get(0),
                    initialGenre.get(0)
            )) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(new Song("The Last Day",
                    initialAlbums.get(0),
                    initialArtists.get(0),
                    initialPlaylists.get(0),
                    initialGenre.get(0)
            )) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(new Song("Solitude Street",
                    initialAlbums.get(1),
                    initialArtists.get(1),
                    initialPlaylists.get(1),
                    initialGenre.get(1)
            )) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(new Song("Shootout At McDonalds",
                    initialAlbums.get(1),
                    initialArtists.get(1),
                    initialPlaylists.get(1),
                    initialGenre.get(1)
            )) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(new Song("All My Haters In The Dust",
                    initialAlbums.get(1),
                    initialArtists.get(1),
                    initialPlaylists.get(1),
                    initialGenre.get(1)
            )) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(new Song("All My Homies By My Side",
                    initialAlbums.get(1),
                    initialArtists.get(1),
                    initialPlaylists.get(1),
                    initialGenre.get(1)
            )) + "\n");
            LoggerUtil.log.info("Preloading " + repository.save(new Song("Big Bucks Small Lies",
                    initialAlbums.get(1),
                    initialArtists.get(1),
                    initialPlaylists.get(1),
                    initialGenre.get(1)
            )) + "\n");
        };
    }
}
