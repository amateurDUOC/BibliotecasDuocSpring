package com.bibliotecaduoc.biblioteca_duoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecaduoc.biblioteca_duoc.model.Libro;
import com.bibliotecaduoc.biblioteca_duoc.repository.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    
    public List<Libro> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.guardaLibro(libro);
    }

    public Libro getLibroId(int id){
        return libroRepository.buscarId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepository.actualizaLibro(libro);
    }

    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "Libro eliminado";
    }
}
