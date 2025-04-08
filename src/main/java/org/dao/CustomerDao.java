package org.dao;

import org.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.Factory;

import static org.util.Factory.FACTORY;

public class CustomerDao {

    public Customer save(Customer customer) {
        Transaction transaction = null;
        try (Session session = FACTORY.openSession()) {
            try {
                transaction = session.beginTransaction();
                session.merge(customer);
                transaction.commit();
                return customer;
            }catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
        }
            return null;

        }
    }
    public Customer getCustomerById(Short id) {
        try (Session session = FACTORY.openSession()) {
            return session.get(Customer.class, id);
        }
    }
}
