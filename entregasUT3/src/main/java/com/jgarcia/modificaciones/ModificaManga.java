package com.jgarcia.modificaciones;

import com.jgarcia.HibernateUtil;
import com.jgarcia.entidades.Manga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//App que actualiza el numero de capitulos de un manga
public class ModificaManga {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Manga manga1 = session.get(Manga.class,1);
        Manga manga2 = session.get(Manga.class,3);

        System.out.println("\nEl manga " + manga1.getTitulo() + " ha sacado capítulo!");

        manga1.setCapitulos(manga1.getCapitulos() + 1);
        manga2.setCapitulos(manga2.getCapitulos() + 1);

        session.detach(manga2);

        tr.commit();
        session.close();
    }
}
