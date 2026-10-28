package com.actividad9_1.actividad9_1;


import Clase.Producto;
import Clase.Respuesta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class catalogoController {

    List<Producto> productos = new ArrayList<>(List.of(
            new Producto(1,"Champu",2.9),
            new Producto(2,"Gel",1.5),
            new Producto(3,"Esponja",1.1)
    ));

    @GetMapping("/")
    public ResponseEntity<?> mostrarProductos(){

        if(productos.isEmpty()){

            Respuesta respuesta = new Respuesta("No hay productos");
            System.out.println(respuesta);
            return ResponseEntity.notFound().build();

        }else{
            for (Producto producto : productos){
                System.out.println(producto);
            }
           return ResponseEntity.ok(productos);
        }
    }


    @GetMapping("/buscar")
    public ResponseEntity<?> buscarProducto(@RequestParam(name = "id", required=true) Integer id){

        boolean encontrado = false;

        for (Producto producto : productos){

            if(producto.getId().equals(id)){
                encontrado = true;
                System.out.println(producto);
            }
        }

        if(encontrado){
            return ResponseEntity.ok(productos);
        }else{
            Respuesta respuesta = new Respuesta("no existe ningun prducto con ese id");
            System.out.println(respuesta);
            return ResponseEntity.notFound().build();

        }

    }

    @GetMapping("/resumen")
    public ResponseEntity<?> resumen(){

        int contador = 0;

        for (Producto producto : productos){
            contador++;
        }

        if(contador>=3){
            Respuesta respuesta = new Respuesta("Hay 3 productos");
            return ResponseEntity.ok(respuesta);
        }else{
            return ResponseEntity.noContent().build();
        }

    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevoProducto(@RequestParam(name="",required = true),
                                           @RequestParam(name="",required = true),
                                           @RequestParam(name="id",required = true)Integer id){

    }


}
