package com.cristianguerrerodev.apirestalbumcollection.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumDTO {

    private Long id;
    private String title;
    private String genre;
    private int year;
    private String artist;
    private String label;

}
