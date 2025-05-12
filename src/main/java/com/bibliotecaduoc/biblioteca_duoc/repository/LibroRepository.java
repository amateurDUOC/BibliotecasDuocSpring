package com.bibliotecaduoc.biblioteca_duoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bibliotecaduoc.biblioteca_duoc.model.Libro;

@Repository
public class LibroRepository {

    // Arreglo para guardar libros
    private List<Libro> listaLibros = new ArrayList<>();

    // Método para listar libros
    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    // Buscar un libro por id
    public Libro buscarId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;                
            }
        }
        return null;
    }

    // Buscar un libro por isbn
    public Libro buscarIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // Método para agregar libro
    public Libro guardaLibro(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    // Método para actualizar libro
    public Libro actualizaLibro(Libro lib){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;
    }

    // Método para eliminar libro
    public void eliminar(int id){
        
        // Alternativa 1: Utilizar método buscarId
        Libro libro = new Libro();
        if (libro != null) {
            listaLibros.remove(libro);
        }

        // Alternativa 2: Utilizar for para buscar id
        int idPosicion = 0;
        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion > 0) {
            listaLibros.remove(idPosicion);
        }

        // Alternativa 3: Utilizar método removeIf con expresión lambda
        listaLibros.removeIf(x -> x.getId() == id);
    }
}
