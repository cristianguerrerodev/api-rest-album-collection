package com.cristianguerrerodev.apirestalbumcollection.dto.converter;

import com.cristianguerrerodev.apirestalbumcollection.dto.AlbumDTO;
import com.cristianguerrerodev.apirestalbumcollection.model.Album;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@RequiredArgsConstructor
public class AlbumDTOConverter {

    private final ModelMapper modelMapper;

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

}
