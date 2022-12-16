package com.jgarcia.consultas;

import com.jgarcia.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

//App que mostrará cuantos mangas hay con el mismo número de capitulos
public class AppConsulta2 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Query<Object []> q = ss.createQuery("Select capitulos,count(M.capitulos) from Manga M group by M.capitulos");

        List<Object []> mangas = q.list();

        for(Object[] m: mangas)
            System.out.println("Los de " + m[0] + " capitulos son " + m[1] + " mangas");
    }
}
