package ru.dzolotarev.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import ru.dzolotarev.entities.Manager;

import java.util.List;

@Component
public class ManagerDAO {
    private final DBConnection dbConnection;

    public ManagerDAO(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Manager> findAll() {
        List<Manager> managerList = null;
        Session session = dbConnection.getSession(Manager.class);
        try (session) {
            session.beginTransaction();
            Query<Manager> managers = session.createQuery("select m from Manager m", Manager.class);
            managerList = managers.list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
//            session.getTransaction().rollback();
        }
        return managerList;
    }
}
