package com.ejerRepaso2.ejerRepaso2.modelo;

import java.util.ArrayList;

public class Catalogo {

     ArrayList<Libro> libros;


    public Catalogo(ArrayList<Libro> libros) {

        this.libros = libros;

    }

    Libro libro1 = new Libro(1,"Don Quijote de la Mancha","Miguel de Cervantes","Aventura",2);
    Libro libro2 = new Libro(2,"La casa de Bernarda Alba","","Drama",0);
    Libro libro3 = new Libro(3,"El principito","","Fantasía",3);
    Libro libro4 = new Libro(4,"Harry Potter y la piedra filosofal","J.K Rowling","Fantasía",10);
    Libro libro5 = new Libro(5,"Geronimo Stilton","","Aventura",15);



}
