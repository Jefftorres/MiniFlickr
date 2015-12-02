package com.example.estudiante.miniflickr.modelos;

/**
 * Created by ESTUDIANTE on 02/12/2015.
 */
public class Imagen {
    private int recurso;
    private String titulo, autor;
    private int likes;

    public Imagen(int recurso, String titulo, String autor, int likes) {
        this.recurso = recurso;
        this.titulo = titulo;
        this.autor = autor;
        this.likes = likes;
    }

    public int getRecurso() {
        return recurso;
    }

    public void setRecurso(int recurso) {
        this.recurso = recurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
