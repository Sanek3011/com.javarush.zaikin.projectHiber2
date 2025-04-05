package org.dao;

import org.entity.Inventory;
import org.entity.Rental;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.util.Factory;

import static org.util.Factory.FACTORY;

public class RentalDao {


    public Rental getRentalById(Integer id) {
        try (Session session = FACTORY.openSession()) {
            return session.get(Rental.class, id);

        }
    }

    public void update(Rental rental) {
        Transaction transaction = null;
        try (Session session = FACTORY.openSession()) {
            transaction = session.beginTransaction();
            session.merge(rental);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}
