package com.ejerRepaso2.ejerRepaso2.controller;


import com.ejerRepaso2.ejerRepaso2.modelo.Libro;
import com.ejerRepaso2.ejerRepaso2.modelo.Prestamo;
import com.ejerRepaso2.ejerRepaso2.modelo.Respuesta;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class prestamoController {

    List<Libro> catalogo = new ArrayList<>();

    public prestamoController(){

        catalogo.add(new Libro(1,"Hola1","miguel","fantasia",2));
        catalogo.add(new Libro(2,"Hola2","jose","accion",10));
        catalogo.add(new Libro(3,"Hola3","jony","misterio",0));
        catalogo.add(new Libro(4,"Hola4","samuel","amor",5));
        catalogo.add(new Libro(5,"Hola5","diego","fantasia",0));
    }

    @PostMapping("/prestamo")
    public Respuesta procesarPrestamo(@ModelAttribute Prestamo prestamo){


        Libro libroEncontrado = null;

        for (Libro libro : catalogo){

            if(libro.getId() == prestamo.getLibroId()){
                libroEncontrado = libro;
                break;
            }

        }

        if(libroEncontrado == null){

            return new Respuesta("RECHAZADO","Libro no encontrado");

        }

        if(libroEncontrado.getEjemplaresDisponibles()==0){
            return new Respuesta("RECHAZADO","Sin ejemplares disponibles");
        }

        if(prestamo.getDiasPrestamo()<1 || prestamo.getDiasPrestamo()>30){

            return new Respuesta("RECHAZADO","Duración no válida (1-30 días)");
        }


        int ejemplaresRestantes = libroEncontrado.getEjemplaresDisponibles()-1;

        int diasTotales = prestamo.getDiasPrestamo();

        if(prestamo.isCarnetPremium()){
            diasTotales+= 7;
        }

        LocalDate fechaDevolucion = LocalDate.now().plusDays(diasTotales);

        libroEncontrado.setEjemplaresDisponibles(ejemplaresRestantes);

        return new Respuesta("CONFIRMADO",prestamo.getNombreSocio(),libroEncontrado.getTitulo(),diasTotales,fechaDevolucion);




    }

    @GetMapping("/libros")
    public List<?> buscadorLibros(@RequestParam(name = "categoria",required = false) String categoria,
                                @RequestParam(name="autor", required = false) String autor,
                                @RequestParam(name="soloDisponibles", defaultValue = "false", required = false)Boolean soloDisponibles){

        List<Libro> resultado = new ArrayList<>();

        for (Libro libro : catalogo){
            boolean mostrarLibro = true;

            if(libro.getCategoria()!= null && !libro.getCategoria().equals(categoria)){
                mostrarLibro = false;
            }

            if(libro.getAutor() != null && !libro.getAutor().toLowerCase().equals(autor)){
                mostrarLibro = false;
            }

            if(soloDisponibles && libro.getEjemplaresDisponibles()==0){
                mostrarLibro = false;
            }

            if(mostrarLibro){

             resultado.add(libro);
            }

        }


        return resultado;

    }


    @GetMapping("/libro")
    public Object consultaLibro(@RequestParam(name="id")Integer id){

        for (Libro libro : catalogo){

            if(libro.getId().equals(id)){

                return libro;

            }



            }

        return new Respuesta("RECHAZADO","Libro no encontrado");

    }



}
