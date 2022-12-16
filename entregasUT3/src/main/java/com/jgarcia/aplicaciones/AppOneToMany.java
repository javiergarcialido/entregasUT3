package com.jgarcia.aplicaciones;

import com.jgarcia.HibernateUtil;
import com.jgarcia.entidades.Manga;
import com.jgarcia.entidades.PersonajeSecundario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

//Apliación que hace uso de la relación N - 1 de personaje secundario y manga
public class AppOneToMany {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Manga manga1 = new Manga("Boku No hero", 300, null, null, null);
        Manga manga2 = new Manga("Jusutsu Kaisen", 150, null, null, null);

        PersonajeSecundario personajeSecundario1 = new PersonajeSecundario("Al Might", "humano", manga1);
        PersonajeSecundario personajeSecundario2 = new PersonajeSecundario("Kurogiri", "vacio", manga1);

        ArrayList<PersonajeSecundario> personajesSecundarios1 = new ArrayList<>();
        personajesSecundarios1.add(personajeSecundario1); personajesSecundarios1.add(personajeSecundario2);

        PersonajeSecundario personajeSecundario3 = new PersonajeSecundario("Gojo Satoru", "hechicero", manga2);
        PersonajeSecundario personajeSecundario4 = new PersonajeSecundario("Sukuna Ryoumen", "maldicion", manga2);

        ArrayList<PersonajeSecundario> personajesSecundarios2 = new ArrayList<>();
        personajesSecundarios1.add(personajeSecundario3); personajesSecundarios1.add(personajeSecundario4);

        ss.persist(personajeSecundario1); ss.persist(personajeSecundario3);
        t.commit();

        ss.close();
    }
}
