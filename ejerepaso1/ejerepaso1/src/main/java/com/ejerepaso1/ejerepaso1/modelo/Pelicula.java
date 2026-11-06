package com.ejerepaso1.ejerepaso1.modelo;

public class Pelicula {

    private Integer id;
    private String titulo;
    private Double precioBase;
    private Integer asientosLibres;

    public Pelicula() {
    }

    public Pelicula(Integer id, String titulo, Double precioBase, Integer asientosLibres) {
        this.id = id;
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.asientosLibres = asientosLibres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Integer getAsientosLibres() {
        return asientosLibres;
    }

    public void setAsientosLibres(Integer asientosLibres) {
        this.asientosLibres = asientosLibres;
    }
}
