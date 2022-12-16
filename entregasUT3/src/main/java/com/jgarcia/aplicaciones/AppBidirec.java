package com.jgarcia.aplicaciones;

import com.jgarcia.HibernateUtil;
import com.jgarcia.entidades.Lector;
import com.jgarcia.entidades.Manga;
import com.jgarcia.entidades.PersonajePrincipal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

//Apliación que hace uso de la relación 1 - 1 bidireccional de personaje principal y manga
public class AppBidirec {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Manga manga1 = new Manga("Dragon Ball", 500, null, null, null);
        Manga manga2 = new Manga("Fairy Tail", 666, null, null, null);
        Manga manga3 = new Manga("One Punch Man", 210, null, null, null);

        PersonajePrincipal personajePrincipal1 = new PersonajePrincipal("Goku", manga1);
        PersonajePrincipal personajePrincipal2 = new PersonajePrincipal("Natsu", manga2);
        PersonajePrincipal personajePrincipal3 = new PersonajePrincipal("Saitama", manga3);

        manga1.setPersonajePrincipal(personajePrincipal1); manga2.setPersonajePrincipal(personajePrincipal2); manga3.setPersonajePrincipal(personajePrincipal3);

        ss.persist(manga1); ss.persist(manga2); ss.persist(manga3);
        t.commit();

        ss.close();
    }
}
