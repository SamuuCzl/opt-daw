package com.ejerRepaso2.ejerRepaso2.modelo;

import java.time.LocalDate;

public class Respuesta {

    private String estado;
    private String socio;
    private  String libro;
    private Integer diasTotales;
    private LocalDate fechaDevolucion;
    private String motivo;

    public Respuesta(String estado, String socio, String libro, Integer diasTotales, LocalDate fechaDevolucion) {
        this.estado = estado;
        this.socio = socio;
        this.libro = libro;
        this.diasTotales = diasTotales;
        this.fechaDevolucion = fechaDevolucion;
    }


    public Respuesta(String estado, String motivo) {
        this.estado = "RECHAZADO";
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public Integer getDiasTotales() {
        return diasTotales;
    }

    public void setDiasTotales(Integer diasTotales) {
        this.diasTotales = diasTotales;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
