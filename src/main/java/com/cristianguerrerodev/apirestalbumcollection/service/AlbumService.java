package com.cristianguerrerodev.apirestalbumcollection.service;

import com.cristianguerrerodev.apirestalbumcollection.dto.CreateAlbumDTO;
import com.cristianguerrerodev.apirestalbumcollection.dto.converter.AlbumDTOConverter;
import com.cristianguerrerodev.apirestalbumcollection.error.AlbumNotFoundException;
import com.cristianguerrerodev.apirestalbumcollection.model.Album;
import com.cristianguerrerodev.apirestalbumcollection.repository.AlbumRepository;
import com.cristianguerrerodev.apirestalbumcollection.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService extends BaseService<Album, Long, AlbumRepository> {

    private final ArtistService artistService;
    private final LabelService labelService;
    private final AlbumDTOConverter albumDTOConverter;

    public Album saveAlbum(CreateAlbumDTO albumDTO){
        Album album = albumDTOConverter.convertDtoToAlbum(albumDTO);

        return this.save(album);
    }

    public Album editAlbum(Long id, CreateAlbumDTO albumDTO) throws AlbumNotFoundException {
        Album album = this.findById(id).map(a -> {
            albumDTOConverter.convertDtoToAlbum(a, albumDTO);
            return this.save(a);
        }).orElseThrow(() -> new AlbumNotFoundException());

        album.setTitle(albumDTO.getTitle());
        album.setGenre(albumDTO.getGenre());
        album.setYear(albumDTO.getYear());
        album.setArtist(artistService.findById(albumDTO.getArtist_id()).orElse(null));
        album.setLabel(labelService.findById(albumDTO.getLabel_id()).orElse(null));

        return this.save(album);
    }

}
