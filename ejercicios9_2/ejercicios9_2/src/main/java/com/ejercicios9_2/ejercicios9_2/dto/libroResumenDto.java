package com.ejercicios9_2.ejercicios9_2.dto;

public class libroResumenDto {
    private int id;
    private String titulo;

    public libroResumenDto(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
