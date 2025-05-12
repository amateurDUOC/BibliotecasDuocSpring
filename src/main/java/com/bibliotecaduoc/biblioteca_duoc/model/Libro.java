package com.bibliotecaduoc.biblioteca_duoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getters, setters, toString, equals, hashCode y constructor con campos requeridos
@AllArgsConstructor // constructor con todos los campos
@NoArgsConstructor // constructor vacío
public class Libro {

    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;

}
