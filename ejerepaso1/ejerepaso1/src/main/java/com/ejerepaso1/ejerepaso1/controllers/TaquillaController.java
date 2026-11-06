package com.ejerepaso1.ejerepaso1.controllers;

import com.ejerepaso1.ejerepaso1.Enums.Estado;
import com.ejerepaso1.ejerepaso1.modelo.Pelicula;
import com.ejerepaso1.ejerepaso1.modelo.Reserva;
import com.ejerepaso1.ejerepaso1.modelo.Respuesta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaquillaController {

    // Guardamos las obras al iniciar el programa
    Pelicula[] peliculas = {
            new Pelicula(101, "La Casa de Bernarda Alba", 25.0, 10),
            new Pelicula(102, "Yerma", 32.0, 5),
            new Pelicula(103, "El Tragaluz", 18.0, 20)
    };


    // Mostramos el formulario
    @GetMapping("/reserva")
    public String mostrarFormulario() {
        return "formulario";
    }


    // Buscamos las obras según los filtros recibidos
    @GetMapping("/cartelera")
    @ResponseBody
    public List<Pelicula> buscarCartelera(
            @RequestParam(required = false) Double precioMax,
            @RequestParam(required = false) Boolean soloDisponibles) {

        List<Pelicula> resultado = new ArrayList<>();

        for (Pelicula pelicula : peliculas) {

            boolean mostrar = true;

            if (precioMax != null) {
                if (pelicula.getPrecioBase() > precioMax) {
                    mostrar = false;
                }
            }

            if (soloDisponibles != null) {
                if (soloDisponibles == true && pelicula.getAsientosLibres() <= 0) {
                    mostrar = false;
                }
            }

            if (mostrar == true) {
                resultado.add(pelicula);
            }
        }

        return resultado;
    }


    // Recibimos los datos del formulario
    @PostMapping("/reserva")
    @ResponseBody
    public synchronized Respuesta procesarReserva(@ModelAttribute Reserva reserva) {

        Pelicula pelicula = null;

        // Buscamos la obra por su ID
        for (Pelicula p : peliculas) {

            if (p.getId().equals(reserva.getEventoId())) {
                pelicula = p;
            }
        }

        // Comprobamos si existe la obra
        if (pelicula == null) {
            return new Respuesta(
                    "La obra no existe",
                    Estado.RECHAZADO
            );
        }

        // Comprobamos la cantidad
        if (reserva.getCantidad() == null || reserva.getCantidad() <= 0) {
            return new Respuesta(
                    "La cantidad debe ser mayor que cero",
                    Estado.RECHAZADO
            );
        }

        // Comprobamos el nombre del cliente
        if (reserva.getNombreCliente() == null ||
                reserva.getNombreCliente().isBlank()) {

            return new Respuesta(
                    "El nombre es obligatorio",
                    Estado.RECHAZADO
            );
        }

        // Comprobamos el tipo de entrada
        if (reserva.getTipoEntrada() == null ||
                (!reserva.getTipoEntrada().equals("General") &&
                        !reserva.getTipoEntrada().equals("VIP"))) {

            return new Respuesta(
                    "Tipo de entrada incorrecto",
                    Estado.RECHAZADO
            );
        }

        // Comprobamos que queden asientos suficientes
        if (reserva.getCantidad() > pelicula.getAsientosLibres()) {

            return new Respuesta(
                    "Aforo insuficiente. Asientos disponibles restantes: "
                            + pelicula.getAsientosLibres(),
                    Estado.RECHAZADO
            );
        }

        // Calculamos el precio de una entrada
        double precioUnitario = pelicula.getPrecioBase();

        // Aplicamos el recargo VIP
        if (reserva.getTipoEntrada().equals("VIP")) {
            precioUnitario = precioUnitario * 1.20;
        }

        // Calculamos el subtotal
        double subtotal = precioUnitario * reserva.getCantidad();

        double total = subtotal;

        // Descuento por comprar 4 o más entradas
        if (reserva.getCantidad() >= 4) {
            total = total - (total * 0.10);
        }

        // Descuento por cupón
        if ("DESCUENTO15".equals(reserva.getCodigoCupon())) {
            total = total - (total * 0.15);
        }

        // Redondeamos los resultados
        total = Math.round(total * 100.0) / 100.0;

        double descuentoTotal = subtotal - total;
        descuentoTotal = Math.round(descuentoTotal * 100.0) / 100.0;

        // Restamos los asientos reservados
        pelicula.setAsientosLibres(
                pelicula.getAsientosLibres() - reserva.getCantidad()
        );

        // Devolvemos la reserva confirmada
        return new Respuesta(
                reserva.getNombreCliente(),
                reserva.getCantidad(),
                precioUnitario,
                subtotal,
                descuentoTotal,
                total,
                Estado.CONFIRMADO
        );
    }
}