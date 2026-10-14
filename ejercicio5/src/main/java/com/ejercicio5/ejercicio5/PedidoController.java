package com.ejercicio5.ejercicio5;

import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
public class PedidoController {

    @PostMapping("/pedidos")
    public ResumenPedido recibirPedido(@RequestBody Pedido pedido) {

        int unidades = 0;
        BigDecimal total = BigDecimal.ZERO;

        for (Producto p : pedido.productos) {
            unidades += p.cantidad;

            total = total.add(

                    p.precioUnitario.multiply(BigDecimal.valueOf(p.cantidad))
            );
        }

        ResumenPedido respuesta = new ResumenPedido();

        respuesta.cliente = pedido.cliente.nombre;
        respuesta.totalProductos = unidades;
        respuesta.precioTotal = total;
        respuesta.mensaje = "Pedido recibido correctamente";

        return respuesta;
    }
}