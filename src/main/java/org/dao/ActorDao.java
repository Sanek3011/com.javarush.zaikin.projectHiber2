package org.dao;

import org.entity.Actor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.util.Factory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.util.Factory.FACTORY;

public class ActorDao {

    public Set<Actor> getFirstTenActors(){
        try (Session session = FACTORY.openSession()) {
            Query<Actor> fromActor = session.createQuery("from Actor ", Actor.class);
            fromActor.setMaxResults(10);
            List<Actor> list = fromActor.list();
            return new HashSet<>(list);
        }
    }

}
