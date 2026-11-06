package com.ejercicios9_2.ejercicios9_2.model;

public class libro {

    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int anioPublicacion;
    private boolean prestado;
    private String notasInternas;

    public libro(int id, String titulo, String autor, String isbn,
                 int anioPublicacion, String notasInternas) {

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }

        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }

        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("El ISBN no puede estar vacío");
        }

        if (anioPublicacion <= 0) {
            throw new IllegalArgumentException("El año de publicación no es válido");
        }

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.prestado = false;
        this.notasInternas = notasInternas;
    }

    public void prestar() {
        if (prestado) {
            throw new IllegalStateException("El libro ya está prestado");
        }
        prestado = true;
    }

    public void devolver() {
        if (!prestado) {
            throw new IllegalStateException("El libro no está prestado");
        }
        prestado = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public String getNotasInternas() {
        return notasInternas;
    }
}
