package org.dao;

import org.entity.Film;
import org.entity.Inventory;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

import static org.util.Factory.FACTORY;

public class FilmDao {
    public Film getFilmById(Short id){
        try (Session session = FACTORY.openSession()) {
            return session.get(Film.class, id);
        }
    }

}
