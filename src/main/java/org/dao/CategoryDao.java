package org.dao;

import org.entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.util.Factory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.util.Factory.FACTORY;

public class CategoryDao {

    public Set<Category> getFiveCategories(){
        try (Session session = FACTORY.openSession()) {
            Query<Category> fromCategory = session.createQuery("from Category ", Category.class);
            fromCategory.setMaxResults(5);
            List<Category> list = fromCategory.list();
            return new HashSet<>(list);
        }
    }
}
