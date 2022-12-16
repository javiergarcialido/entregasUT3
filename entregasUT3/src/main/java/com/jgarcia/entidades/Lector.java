package com.jgarcia.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "lectores")
public class Lector implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private boolean socio;

    //Relación N - M con manga
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="lector_manga",
            joinColumns = {@JoinColumn(name="FK_lector",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="FK_manga",referencedColumnName = "id")})
    private List<Manga> mangas;

    public Lector() {
    }

    public Lector(String nombre, boolean socio, List<Manga> manga) {
        this.nombre = nombre;
        this.socio = socio;
        this.mangas = manga;
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

    public boolean isSocio() {
        return socio;
    }

    public void setSocio(boolean socio) {
        this.socio = socio;
    }

    public List<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", socio=" + socio +
                ", manga=" + mangas +
                '}';
    }
}
