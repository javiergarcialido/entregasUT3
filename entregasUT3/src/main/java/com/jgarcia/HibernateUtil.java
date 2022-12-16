package com.jgarcia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        }
        return factory;
    }
}
