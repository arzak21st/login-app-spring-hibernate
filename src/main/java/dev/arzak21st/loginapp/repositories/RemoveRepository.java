package dev.arzak21st.loginapp.repositories;

import dev.arzak21st.loginapp.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RemoveRepository {

    /* ========== VARIABLES ========== */
    User user;

    boolean userIsRemoved;

    SessionFactory sessionFactory;
    Session session;

    /* ========== CONSTRUCTORS ========== */
    public RemoveRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /* ========== METHODS ========== */
    public boolean removeUserById(Integer userId) {

        userIsRemoved = false;
        session = null;

        try {

            session = sessionFactory.openSession();
            session.beginTransaction();

            user = session.get(User.class, userId);

            session.remove(user);
            session.getTransaction().commit();

            userIsRemoved = true;
        }
        catch(Exception exception) {
            userIsRemoved = false;
        }
        finally {
            session.close();
        }
        
        return userIsRemoved;
    }
}
