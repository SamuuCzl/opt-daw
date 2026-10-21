package com.ejerepaso3.ejerepaso3.controller;

import com.ejerepaso3.ejerepaso3.modelo.respuestaDados;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/juegos") //Si siempre se utiliza esta ruta para acceder a las demas, se puede poner al principio
public class DadoController {


    //Apartado 1
    @GetMapping("/dados")
    public respuestaDados tirarDados(@RequestParam(name="cantidad", required = true, defaultValue = "2")Integer cantidad,
                                     @RequestParam(name ="caras" ,required = true, defaultValue = "6") Integer caras){

        String mensaje = "Resultados";
        int suma = 0;
        boolean dobles = true;
        int primero = 0;

        if(cantidad<1 || cantidad >10){

        //return new respuestaDaods();

        }

        if(caras!= 4,caras!= 6,caras!= 8,caras!= 10,caras!= 12,caras!= 20){
            //return new respuestaDados();
        }
    }


    //Apartado 5
    @GetMapping("/moneda")
    public String caraCruz(@RequestParam(name="lanzaminetos",required = true )Integer lanzamientos){



    }

}
