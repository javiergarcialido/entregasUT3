package com.jgarcia.modificaciones;

import com.jgarcia.HibernateUtil;
import com.jgarcia.entidades.Manga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//App que elimina un manga de la base de datos
public class EliminaManga {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        // obtengo el empleado a eliminar
        Manga manga = ss.get(Manga.class,10);

        System.out.println("\nSe ha borrado el manga " + manga.getTitulo());

        ss.remove(manga);

        t.commit();

        ss.close();
    }
}
