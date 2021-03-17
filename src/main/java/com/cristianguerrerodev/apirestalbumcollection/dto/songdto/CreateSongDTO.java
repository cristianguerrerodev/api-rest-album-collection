package com.cristianguerrerodev.apirestalbumcollection.dto.songdto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateSongDTO {
    private Long id;
    private String title;
    private int track;
    private float length;
    private long artist_id;
    private long album_id;
}
