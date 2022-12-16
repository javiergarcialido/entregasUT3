package com.jgarcia.aplicaciones;

import com.jgarcia.HibernateUtil;
import com.jgarcia.entidades.Autor;
import com.jgarcia.entidades.Manga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//Apliación que hace uso de la relación 1 - 1 unidireccional de autor y manga
public class AppUnidirec {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Manga manga1 = new Manga("Solo Leveling", 169);
        Manga manga2 = new Manga("One Piece", 1070);

        Autor autor1 = new Autor("Pedro Pascal", manga1);
        Autor autor2 = new Autor("Eichiro Oda", manga2);

        ss.persist(autor1); ss.persist(autor2);
        t.commit();

        ss.close();
    }
}
