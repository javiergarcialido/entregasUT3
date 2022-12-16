package com.jgarcia.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "personajesSacundarios")
@DiscriminatorValue(value = "Secundario")
public class PersonajeSecundario extends PersonajePrincipal implements Serializable {
    @Column
    private String raza;

    //Relación N - 1 con manga
    @ManyToOne(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
    @JoinColumn(name="FK_manga1",referencedColumnName = "id")
    private Manga manga1;

    public PersonajeSecundario() {super();}

    public PersonajeSecundario(String raza, Manga manga) {
        super();
        this.raza = raza;
        this.manga1 = manga;
    }

    public PersonajeSecundario(String nombre, String raza, Manga manga) {
        super(nombre);
        this.raza = raza;
        this.manga1 = manga;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Manga getManga() {
        return manga1;
    }

    public void setManga(Manga manga) {
        this.manga1 = manga;
    }

    @Override
    public String toString() {
        return "PersonajeSecundario{" +
                "raza='" + raza + '\'' +
                ", manga=" + manga1 +
                '}';
    }
}
