package com.cristianguerrerodev.apirestalbumcollection;

import com.cristianguerrerodev.apirestalbumcollection.model.Album;
import com.cristianguerrerodev.apirestalbumcollection.model.Artist;
import com.cristianguerrerodev.apirestalbumcollection.model.Label;
import com.cristianguerrerodev.apirestalbumcollection.model.Song;
import com.cristianguerrerodev.apirestalbumcollection.repository.AlbumRepository;
import com.cristianguerrerodev.apirestalbumcollection.repository.ArtistRepository;
import com.cristianguerrerodev.apirestalbumcollection.repository.LabelRepository;
import com.cristianguerrerodev.apirestalbumcollection.repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ApiRestAlbumCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestAlbumCollectionApplication.class, args);
    }

//    @Bean
//    CommandLineRunner init(LabelRepository labelRepository, ArtistRepository artistRepository,
//                           AlbumRepository albumRepository, SongRepository songRepository) {
//        return (args) -> {
//            List<Label> labelList = labelRepository.findAll();
//            List<Artist> artistList  = artistRepository.findAll();
//            List<Album> albumList = albumRepository.findAll();
//            List<Song> songList = songRepository.findAll();
//
//            for (Label label : labelList) {
//                System.out.println(label.toString());
//            }
//
//            for (Artist artist : artistList){
//                System.out.println(artist.toString());
//            }
//
//            for (Album album : albumList){
//                System.out.println(album.toString());
//            }
//
//            for (Song song : songList){
//                System.out.println(song.toString());
//            }
//        };
//    }

}
