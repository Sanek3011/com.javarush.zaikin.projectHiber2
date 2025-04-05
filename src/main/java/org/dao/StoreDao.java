package org.dao;

import org.entity.Store;
import org.hibernate.Session;
import org.util.Factory;

import static org.util.Factory.FACTORY;

public class StoreDao {

    public Store getStoreById(Byte id) {
        try (Session session = FACTORY.openSession()) {
            Store store = session.get(Store.class, id);
            return store;
        }

    }

}
