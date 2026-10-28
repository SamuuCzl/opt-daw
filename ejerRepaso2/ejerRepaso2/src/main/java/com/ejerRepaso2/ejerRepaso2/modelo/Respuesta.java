package com.ejerRepaso2.ejerRepaso2.modelo;

import java.util.Date;

public class Respuesta {

    public String estado;
    public String socio;
    public String libro;
    public Integer diasTotales;
    public Date fechaDevolucion;

    public Respuesta() {
    }

    public Respuesta(String estado, String socio, String libro, Integer diasTotales, Date fechaDevolucion) {
        this.estado = estado;
        this.socio = socio;
        this.libro = libro;
        this.diasTotales = diasTotales;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getDiasTotales() {
        return diasTotales;
    }

    public void setDiasTotales(Integer diasTotales) {
        this.diasTotales = diasTotales;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }
}
