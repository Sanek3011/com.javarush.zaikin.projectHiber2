package org.dao;

import org.entity.Film;
import org.entity.Inventory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.util.Factory;

import java.util.List;

import static org.util.Factory.FACTORY;

public class InventoryDao {

    public Inventory getInventoryById(Integer id){
        try (Session session = FACTORY.openSession()) {
            return session.get(Inventory.class, id);
        }
    }

    public void save(Inventory inventory) {
        Transaction transaction = null;
        try (Session session = FACTORY.openSession()) {
            transaction = session.beginTransaction();
            session.merge(inventory);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public Integer getAvailableFilm() {
        try (Session session = FACTORY.openSession()) {
            NativeQuery<Integer> nativeQuery = session.createNativeQuery("SELECT i.inventory_id\n" +
                                                                "FROM movie.inventory i\n" +
                                                                "         LEFT JOIN movie.rental r ON i.inventory_id = r.inventory_id\n" +
                                                                "GROUP BY i.inventory_id\n" +
                                                                "HAVING COUNT(r.rental_id) = 0\n" +
                                                                "    OR MAX(r.return_date) IS NOT NULL;", Integer.class);
            return nativeQuery.list().get(0);
        }
    }
}
