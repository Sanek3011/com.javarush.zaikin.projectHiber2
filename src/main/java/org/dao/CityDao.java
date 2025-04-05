package org.dao;

import org.entity.City;
import org.hibernate.Session;
import org.util.Factory;

import static org.util.Factory.FACTORY;

public class CityDao {
    
    public City getCityById(Short id) {
        try (Session session = FACTORY.openSession()) {
            return session.get(City.class, id);
        }
    }
    
}
