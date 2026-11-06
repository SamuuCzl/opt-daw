package com.ejerepaso1.ejerepaso1.modelo;

import com.ejerepaso1.ejerepaso1.Enums.Estado;

public class Respuesta {

    private Estado estado;
    private String motivo;
    private String cliente;
    private Integer entradas;
    private Double precioUnitario;
    private Double subtotal;
    private Double descuentoTotal;
    private Double totalAPagar;

    // Constructor para una reserva rechazada
    public Respuesta(String motivo, Estado estado) {
        this.motivo = motivo;
        this.estado = estado;
    }

    // Constructor para una reserva confirmada
    public Respuesta(String cliente, Integer entradas,
                     Double precioUnitario, Double subtotal,
                     Double descuentoTotal, Double totalAPagar,
                     Estado estado) {

        this.cliente = cliente;
        this.entradas = entradas;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuentoTotal = descuentoTotal;
        this.totalAPagar = totalAPagar;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getCliente() {
        return cliente;
    }

    public Integer getEntradas() {
        return entradas;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Double getDescuentoTotal() {
        return descuentoTotal;
    }

    public Double getTotalAPagar() {
        return totalAPagar;
    }
}
