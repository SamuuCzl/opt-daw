
package com.ejercicio6.ejercicio6;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@Controller
public class RegistroController {

    Random random = new Random();

    Map<String, String> usuarios = new HashMap<>();

    public RegistroController() {
        usuarios.put("ana@example.com", "246810");
        usuarios.put("luis@example.com", "clave123");
    }

    @GetMapping("/registro")
    public String mostrarFormulario() {

        return "formulario";
    }

    @PostMapping("/registro")
    @ResponseBody
    public String procesarFormulario(@ModelAttribute Registro registro) {

        if (registro.getNombre() == null || registro.getNombre().isBlank()) {
            return "El nombre es obligatorio";
        }

        if (registro.getCorreo() == null || registro.getCorreo().isBlank()) {
            return "El correo es obligatorio";
        }

        if (registro.getApellidos() == null || registro.getApellidos().isEmpty()) {
            registro.setApellidos("");
        }

        boolean generada = false;

        if (registro.getContraseña() == null || registro.getContraseña().isEmpty()) {
            int numero = random.nextInt(1000000);
            String contraseña = String.format("%06d", numero);
            registro.setContraseña(contraseña);
            generada = true;
        }

        usuarios.put(registro.getCorreo(), registro.getContraseña());

        String mensaje = "Usuario registrado: " + registro.getNombre()
                + " " + registro.getApellidos()
                + "\nCorreo: " + registro.getCorreo();

        if (generada) {
            mensaje += "\nContraseña generada: " + registro.getContraseña();
        }

        return mensaje;
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String procesarLogin(@RequestParam String usuario,
                                @RequestParam String contraseña) {

        if (!usuarios.containsKey(usuario)) {
            return "Usuario inexistente";
        }

        if (usuarios.get(usuario).equals(contraseña)) {
            return "Inicio de sesión correcto";
        }

        return "Contraseña incorrecta";
    }
}
