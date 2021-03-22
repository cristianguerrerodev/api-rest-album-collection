package com.cristianguerrerodev.apirestalbumcollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiRestAlbumCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestAlbumCollectionApplication.class, args);
    }

//    @Bean
//    CommandLineRunner init(LabelRepository labelRepository, ArtistRepository artistRepository,
//                           AlbumRepository albumRepository, SongRepository songRepository) {
////        return (args) -> {
////            Album album = albumRepository.findById(1L).orElse(null);
////            CreateAlbumDTO albumDTO = new CreateAlbumDTO();
////            albumDTO.setId(album.getId());
////            albumDTO.setTitle(album.getTitle());
////            albumDTO.setGenre(album.getGenre());
////            albumDTO.setYear(album.getYear());
////            albumDTO.g
////            Album album = albumRepository.findById(1L).orElse(null);
////            System.out.println(album.toString());
////
////            List<Song> songList = album.getSongList();
////
////            if (songList.isEmpty()){
////                System.out.println("ESTÁ VACÍA");
////            }else {
////                System.out.println("NO ESTÁ VACÍA");
////                for (Song song : songList){
////                    System.out.println(song.toString());
////                };
////            }
//
//
////            List<Label> labelList = labelRepository.findAll();
////            List<Artist> artistList  = artistRepository.findAll();
////            List<Album> albumList = albumRepository.findAll();
////            List<Song> songList = songRepository.findAll();
////
////            for (Label label : labelList) {
////                System.out.println(label.toString());
////            }
////
////            for (Artist artist : artistList){
////                System.out.println(artist.toString());
////            }
////
////            for (Album album : albumList){
////                System.out.println(album.toString());
////            }
////
////            for (Song song : songList){
////                System.out.println(song.toString());
////            }
//        };
//    }

}
