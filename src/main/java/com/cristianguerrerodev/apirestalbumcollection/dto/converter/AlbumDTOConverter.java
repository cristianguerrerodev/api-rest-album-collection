package com.cristianguerrerodev.apirestalbumcollection.dto.converter;

import com.cristianguerrerodev.apirestalbumcollection.dto.AlbumDTO;
import com.cristianguerrerodev.apirestalbumcollection.dto.CreateAlbumDTO;
import com.cristianguerrerodev.apirestalbumcollection.model.Album;
import com.cristianguerrerodev.apirestalbumcollection.service.ArtistService;
import com.cristianguerrerodev.apirestalbumcollection.service.LabelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@RequiredArgsConstructor
public class AlbumDTOConverter {

    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final LabelService labelService;

    @PostConstruct
    public void init() {
        modelMapper.addMappings(new PropertyMap<Album, AlbumDTO>() {

            @Override
            protected void configure() {
                map().setArtist(source.getArtist().getName());
                map().setLabel(source.getLabel().getName());
            }
        });
    }

    public AlbumDTO convertToDto(Album album) {
        return modelMapper.map(album, AlbumDTO.class);
    }

    public Album convertDtoToAlbum(CreateAlbumDTO albumDTO){
        Album album = new Album();

        album.setTitle(albumDTO.getTitle());
        album.setGenre(albumDTO.getGenre());
        album.setYear(albumDTO.getYear());
        album.setArtist(artistService.findById(albumDTO.getArtist_id()).orElse(null));
        album.setLabel(labelService.findById(albumDTO.getLabel_id()).orElse(null));

        return album;
    }

    public void convertDtoToAlbum(Album album, CreateAlbumDTO albumDTO){

        album.setTitle(albumDTO.getTitle());
        album.setGenre(albumDTO.getGenre());
        album.setYear(albumDTO.getYear());
        album.setArtist(artistService.findById(albumDTO.getArtist_id()).orElse(null));
        album.setLabel(labelService.findById(albumDTO.getLabel_id()).orElse(null));
    }

}
