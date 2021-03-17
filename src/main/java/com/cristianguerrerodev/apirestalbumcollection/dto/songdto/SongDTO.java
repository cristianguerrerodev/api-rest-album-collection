package com.cristianguerrerodev.apirestalbumcollection.dto.songdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongDTO {

    private Long id;
    private String title;
    private int track;
    private float length;
    private String artist;
    private String album;
}
