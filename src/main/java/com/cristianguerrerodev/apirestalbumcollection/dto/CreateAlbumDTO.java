package com.cristianguerrerodev.apirestalbumcollection.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateAlbumDTO {
    private Long id;
    private String title;
    private String genre;
    private int year;
    private long artist_id;
    private long label_id;
}
