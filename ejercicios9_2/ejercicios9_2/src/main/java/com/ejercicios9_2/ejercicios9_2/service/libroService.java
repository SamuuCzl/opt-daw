
package com.ejercicios9_2.ejercicios9_2.service;

import com.ejercicios9_2.ejercicios9_2.model.libro;
import com.ejercicios9_2.ejercicios9_2.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class libroService {

    private List<libro> libros = new ArrayList<>();
    private int siguienteId = 1;

    // Convertimos el libro en el DTO que verá el cliente
    public libroDto convertirDto(libro libro) {

        return new libroDto(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getIsbn(),
                libro.getAnioPublicacion(),
                libro.isPrestado()
        );
    }

    // Buscamos un libro por su ID
    public libro buscarLibro(int id) {

        for (libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "El libro no existe");
    }

    // Creamos un libro nuevo
    public libroDto crearLibro(libroCrearDto datos) {

        // Comprobamos que el ISBN no esté repetido
        for (libro libro : libros) {
            if (libro.getIsbn().equals(datos.getIsbn())) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "El ISBN ya existe");
            }
        }

        libro nuevo = new libro(
                siguienteId,
                datos.getTitulo(),
                datos.getAutor(),
                datos.getIsbn(),
                datos.getAnioPublicacion(),
                ""
        );

        libros.add(nuevo);
        siguienteId++;

        return convertirDto(nuevo);
    }

    // Mostramos todos los libros con su ID y título
    public List<libroResumenDto> listarLibros() {

        List<libroResumenDto> resumen = new ArrayList<>();

        for (libro libro : libros) {
            resumen.add(new libroResumenDto(
                    libro.getId(),
                    libro.getTitulo()
            ));
        }

        return resumen;
    }

    // Obtenemos los datos completos de un libro
    public libroDto obtenerLibro(int id) {

        libro libro = buscarLibro(id);

        return convertirDto(libro);
    }

    // Prestamos un libro
    public libroDto prestarLibro(int id) {

        libro libro = buscarLibro(id);

        libro.prestar();

        return convertirDto(libro);
    }

    // Devolvemos un libro
    public libroDto devolverLibro(int id) {

        libro libro = buscarLibro(id);

        libro.devolver();

        return convertirDto(libro);
    }

    // Eliminamos un libro si no está prestado
    public void eliminarLibro(int id) {

        libro libro = buscarLibro(id);

        if (libro.isPrestado()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "No se puede eliminar un libro prestado");
        }

        libros.remove(libro);
    }
}