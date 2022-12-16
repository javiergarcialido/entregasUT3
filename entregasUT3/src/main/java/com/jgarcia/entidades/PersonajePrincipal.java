package com.jgarcia.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "personajesPrincipales")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "Principal")
public class PersonajePrincipal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;

    //Relación 1 - 1 bidireccional con manga
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_manga",referencedColumnName = "id")
    private Manga manga;

    public PersonajePrincipal() {
    }

    public PersonajePrincipal(String nombre) {
        this.nombre = nombre;
    }

    public PersonajePrincipal(String nombre, Manga manga) {
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

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    @Override
    public String toString() {
        return "PersonajePrincipal{" +
                "id=" + id +
                ", Nombre='" + nombre + '\'' +
                ", manga=" + manga +
                '}';
    }
}
