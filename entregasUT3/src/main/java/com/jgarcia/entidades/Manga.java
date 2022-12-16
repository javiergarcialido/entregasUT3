package com.jgarcia.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mangas")
public class Manga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @Column
    private int capitulos;

    //Relación 1 - 1 bidireccional con personaje principal
    @OneToOne(mappedBy = "manga", cascade = CascadeType.PERSIST)
    private PersonajePrincipal personajePrincipal;

    //Relación 1 - N con personaje secundario
    @OneToMany(mappedBy = "manga1", cascade = CascadeType.PERSIST)
    private List<PersonajeSecundario> personajesSecundarios;

    //Relación N - M con lector
    @ManyToMany(mappedBy = "mangas", cascade = CascadeType.PERSIST)
    private List<Lector> lector;

    public Manga() {
    }

    public Manga(String titulo, int capitulos) {
        this.titulo = titulo;
        this.capitulos = capitulos;
    }

    public Manga(String titulo, int capitulos, PersonajePrincipal personajePrincipal, List<PersonajeSecundario> personajesSecundarios, List<Lector> lector) {
        this.titulo = titulo;
        this.capitulos = capitulos;
        this.personajePrincipal = personajePrincipal;
        this.personajesSecundarios = personajesSecundarios;
        this.lector = lector;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public PersonajePrincipal getPersonajePrincipal() {
        return personajePrincipal;
    }

    public void setPersonajePrincipal(PersonajePrincipal personajePrincipal) {
        this.personajePrincipal = personajePrincipal;
    }

    public List<PersonajeSecundario> getPersonajesSecundarios() {
        return personajesSecundarios;
    }

    public void setPersonajesSecundarios(List<PersonajeSecundario> personajesSecundarios) {
        this.personajesSecundarios = personajesSecundarios;
    }

    public List<Lector> getLector() {
        return lector;
    }

    public void setLector(List<Lector> lector) {
        this.lector = lector;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", capitulos=" + capitulos +
                ", personajePrincipal=" + personajePrincipal +
                ", personajesSecundarios=" + personajesSecundarios +
                ", lector=" + lector +
                '}';
    }
}
