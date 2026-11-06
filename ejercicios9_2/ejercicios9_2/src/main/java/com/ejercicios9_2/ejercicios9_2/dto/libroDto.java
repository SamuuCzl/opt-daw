package com.ejercicios9_2.ejercicios9_2.dto;

public class libroDto {

        private int id;
        private String titulo;
        private String autor;
        private String isbn;
        private int anioPublicacion;
        private boolean prestado;

        public libroDto(int id, String titulo, String autor,
                        String isbn, int anioPublicacion, boolean prestado) {
            this.id = id;
            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
            this.anioPublicacion = anioPublicacion;
            this.prestado = prestado;
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
}
