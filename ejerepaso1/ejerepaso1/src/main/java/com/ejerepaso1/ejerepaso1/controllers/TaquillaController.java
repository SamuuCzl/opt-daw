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

    Pelicula[] peliculas = {new Pelicula(101,"La Casa de Bernarda Alba",25.0,10),
    new Pelicula(102,"",32.0,5),
    new Pelicula(103,"",18.0,20)};

    @GetMapping("/reserva")
    public String formularioReserva(){
        return "formulario";
    }

    @GetMapping("/cartelera")
    @ResponseBody
    public List<Pelicula> consultarbuscarCatelera(@RequestParam(name="precioMax", required = false) Double precioMax,
                                                  @RequestParam(name = "soloDisponibles", required = false)Boolean soloDIsponibles){
        List<Pelicula> peliculasCartelera = new ArrayList<>();

        if(precioMax != null && soloDIsponibles != null){

            for (Pelicula pelicula : peliculas){
                if(pelicula.getPrecio() <= precioMax && pelicula.getAsiento()>0){
                    peliculasCartelera.add(pelicula);
                }
            }

        }else if (precioMax!=null){

            for(Pelicula pelicula : peliculas){
                if(pelicula.getPrecio()<= precioMax) {
                    peliculasCartelera.add(pelicula);
                }
            }
        }else if (soloDIsponibles!= null){
            for(Pelicula pelicula : peliculas){
                if(pelicula.getAsiento()>0) {
                    peliculasCartelera.add(pelicula);
                }
            }
        }else{

            for(Pelicula pelicula: peliculas){
                peliculasCartelera.add(pelicula);
            }
        }
        return peliculasCartelera;
    }


    @PostMapping("/reserva")
    @ResponseBody
    public Respuesta validarReserva(@ModelAttribute Reserva reserva){
        Pelicula pelicula = null;

        for(Pelicula pelicula1:peliculas){
            if(pelicula.getId() == reserva.getEventoId()){
                pelicula = pelicula1;
            }
        }

        if(pelicula == null){
           return new Respuesta("ID de pelicula incorrecto",)
        }

        if(reserva.getCantidad() > pelicula.getAsiento()){

            return new Respuesta("",)
        }

        double precioUnitario = reserva.getTipoEntrada().equals("VIP") ? pelicula.getPrecio() *1.2 : pelicula.getPrecio();
        double importe = precioUnitario* reserva.getCantidad();
        double descuento = 0;
        double importeTemp = importe;

        if(reserva.getCantidad()>= 4){
            descuento = importeTemp*0.1;
            importeTemp-=descuento;
        }

        if(reserva.getCodigoCupon().equals("DESCUENTO15")){
            descuento += importeTemp*0.15;
            importeTemp-=descuento;
        }

        return  new Respuesta(
          reserva.getNombreCliente(),
          reserva.getCantidad(),precioUnitario,importe,descuento,importe-descuento, Estado.CONFIRMADO
        );
    }
}
