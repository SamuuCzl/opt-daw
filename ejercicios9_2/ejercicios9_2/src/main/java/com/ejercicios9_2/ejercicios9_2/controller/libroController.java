
package com.ejercicios9_2.ejercicios9_2.controller;

import com.ejercicios9_2.ejercicios9_2.dto.*;
import com.ejercicios9_2.ejercicios9_2.service.libroService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class libroController {

    private libroService servicio;

    public libroController(libroService servicio) {
        this.servicio = servicio;
    }

    // Crear un libro
    @PostMapping
    public ResponseEntity<libroDto> crear(@RequestBody libroCrearDto datos) {

        libroDto libro = servicio.crearLibro(datos);

        return ResponseEntity.status(HttpStatus.CREATED).body(libro);
    }

    // Mostrar todos los libros
    @GetMapping
    public ResponseEntity<List<libroResumenDto>> listar() {

        return ResponseEntity.ok(servicio.listarLibros());
    }

    // Buscar un libro por su ID
    @GetMapping("/{id}")
    public ResponseEntity<libroDto> buscar(@PathVariable int id) {

        return ResponseEntity.ok(servicio.obtenerLibro(id));
    }

    // Prestar un libro
    @PostMapping("/{id}/prestamo")
    public ResponseEntity<libroDto> prestar(@PathVariable int id) {

        return ResponseEntity.ok(servicio.prestarLibro(id));
    }

    // Devolver un libro
    @PostMapping("/{id}/devolucion")
    public ResponseEntity<libroDto> devolver(@PathVariable int id) {

        return ResponseEntity.ok(servicio.devolverLibro(id));
    }

    // Eliminar un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {

        servicio.eliminarLibro(id);

        return ResponseEntity.noContent().build();
    }

    // Errores cuando no existe un libro o hay algún conflicto
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<errorDto> errorHttp(ResponseStatusException error) {

        return ResponseEntity.status(error.getStatusCode())
                .body(new errorDto(error.getReason()));
    }

    // Errores cuando introducimos datos incorrectos
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<errorDto> errorDatos(IllegalArgumentException error) {

        return ResponseEntity.badRequest()
                .body(new errorDto(error.getMessage()));
    }

    // Errores al prestar o devolver un libro
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<errorDto> errorEstado(IllegalStateException error) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new errorDto(error.getMessage()));
    }

    // Errores cuando enviamos un JSON incorrecto
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<errorDto> errorJson() {

        return ResponseEntity.badRequest()
                .body(new errorDto("Los datos enviados no son válidos"));
    }
}

