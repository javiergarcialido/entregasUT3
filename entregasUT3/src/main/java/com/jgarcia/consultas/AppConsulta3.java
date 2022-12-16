package com.jgarcia.consultas;

import com.jgarcia.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Iterator;

//App que mostrará un listado, en orden alfabético inverso, de todos los mangas
public class AppConsulta3 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<String> q = ss.createQuery("Select titulo from Manga order by titulo desc", String.class);

        Iterator<String> mangas = q.stream().iterator();

        System.out.println("~~~ LISTADO DE MAGAS DE LA BASE DE DATOS ~~~\n\nFiltro: Orden alfabético inverso.\n");

        while (mangas.hasNext())
            System.out.println("- " + mangas.next());
    }
}
