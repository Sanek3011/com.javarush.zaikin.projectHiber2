package org.dao;

import org.entity.Language;
import org.hibernate.Session;
import org.util.Factory;

import static org.util.Factory.FACTORY;

public class LanguageDao {

    public Language getLanguageById(Byte id) {
        try (Session session = FACTORY.openSession()) {
            return session.get(Language.class, id);
        }
    }
}
