package com.ejercicio6.ejercicio6;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class RegistroController {

    Random random = new Random();

    @GetMapping("/registro")
    public String mostrarFormulario(){

        return "formulario";
    }

    @PostMapping("/registro")
    public String procesarFormulario(@ModelAttribute Registro registro){

    if(registro.getApellidos().isEmpty()){
            registro.setApellidos("  ");
        }
        if(registro.getContraseña().isEmpty() || registro.getContraseña() ==null){


        }

        return null;
    }





}
