package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Movie {
    private int id;
    private String name;
    private String posterUrl;
    private String genre;
}
