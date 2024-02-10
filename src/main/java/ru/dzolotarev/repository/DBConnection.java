package ru.dzolotarev.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.Objects;

public class DBConnection {
    private Session session;

    public Session getSession(Class<?> aClass) {
        if (Objects.isNull(session)) {
            SessionFactory sessionFactory = new Configuration()
                    .addAnnotatedClass(aClass)
                    .buildSessionFactory();
            session = sessionFactory.openSession();
        }
        return session;
    }
}
