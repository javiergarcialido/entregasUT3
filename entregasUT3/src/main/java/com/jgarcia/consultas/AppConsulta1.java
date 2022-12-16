package com.jgarcia.consultas;

import com.jgarcia.HibernateUtil;
import com.jgarcia.entidades.Manga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

//App que mostrará el manga que tiene n numero de capitulos
public class AppConsulta1 {
    public static void main(String[] args) {
        int numCapitulos = 1070;

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Manga> q = ss.createQuery("from Manga M where capitulos = :numCapitulos");
        q.setParameter("numCapitulos",numCapitulos);

        Manga manga = (Manga) q.uniqueResult();

        System.out.println("\nEl manga de " + numCapitulos + " capitulos es " + manga.getTitulo());
    }
}
