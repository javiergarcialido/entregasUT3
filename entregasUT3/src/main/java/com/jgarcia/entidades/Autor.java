package com.jgarcia.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "autores")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;

    //Relación 1 - 1 unidireccional con manga
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_manga", referencedColumnName = "id")
    private Manga manga;

    public Autor() {
    }

    public Autor(String nombre, Manga manga) {
        this.nombre = nombre;
        this.manga = manga;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", manga=" + manga +
                '}';
    }
}
