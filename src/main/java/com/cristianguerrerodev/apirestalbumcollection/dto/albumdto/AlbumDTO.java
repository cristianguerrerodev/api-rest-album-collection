package com.cristianguerrerodev.apirestalbumcollection.dto.albumdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDTO {

    private Long id;
    private String title;
    private String genre;
    private int year;
    private String artist;
    private String label;

}
