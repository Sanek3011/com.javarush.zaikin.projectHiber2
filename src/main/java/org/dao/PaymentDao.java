package org.dao;

import org.entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.Factory;

import static org.util.Factory.FACTORY;

public class PaymentDao {
    public void save(Payment payment) {
        Transaction transaction = null;
        try (Session session = FACTORY.openSession()) {
            try {
                transaction = session.beginTransaction();
                session.merge(payment);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
    }
}
