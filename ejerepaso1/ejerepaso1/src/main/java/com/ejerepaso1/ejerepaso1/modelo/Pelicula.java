package com.ejerepaso1.ejerepaso1.modelo;

public class Pelicula {

    public Integer id;
    public String titulo;
    public Double precio;
    public Integer asiento;


    public Pelicula(Integer id, String titulo, Double precio, Integer asiento) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.asiento = asiento;


    }

    public Pelicula() {
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getAsiento() {
        return asiento;
    }

    public void setAsiento(Integer asiento) {
        this.asiento = asiento;
    }
}


