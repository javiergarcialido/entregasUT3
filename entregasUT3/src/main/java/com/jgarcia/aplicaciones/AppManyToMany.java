package com.jgarcia.aplicaciones;

import com.jgarcia.HibernateUtil;
import com.jgarcia.entidades.Lector;
import com.jgarcia.entidades.Manga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

//Apliación que hace uso de la relación N - M de lector y manga
public class AppManyToMany {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();



        Manga manga1 = new Manga("Naruto", 750, null, null, null);
        Manga manga2 = new Manga("Boruto", 250, null, null, null);
        Manga manga3 = new Manga("Leveling With The Gods", 160, null, null, null);

        ArrayList<Manga> mangas1 = new ArrayList<>();
        mangas1.add(manga1); mangas1.add(manga2); mangas1.add(manga3);

        ArrayList<Manga> mangas2 = new ArrayList<>();
        mangas1.add(manga1); mangas1.add(manga2);

        Lector lector1 = new Lector("Javier", true, mangas1);
        Lector lector2 = new Lector("Alberto", false, mangas2);

        ArrayList<Lector> lectores = new ArrayList<>();
        lectores.add(lector1); lectores.add(lector2);

        manga1.setLector(lectores); manga2.setLector(lectores); manga3.setLector(lectores);

        ss.persist(lector1);
        t.commit();

        ss.close();
    }
}
