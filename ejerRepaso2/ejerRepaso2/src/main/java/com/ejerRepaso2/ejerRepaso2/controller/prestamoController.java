package com.ejerRepaso2.ejerRepaso2.controller;

import com.ejerRepaso2.ejerRepaso2.modelo.Libro;
import com.ejerRepaso2.ejerRepaso2.modelo.Catalogo;
import com.ejerRepaso2.ejerRepaso2.modelo.Respuesta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class prestamoController {

    public Respuesta procesarPrestamo(@RequestParam(name="libroId", required = true),
                                      @RequestParam()){




    }
}
