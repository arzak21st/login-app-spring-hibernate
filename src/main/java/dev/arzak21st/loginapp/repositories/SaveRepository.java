package dev.arzak21st.loginapp.repositories;

import dev.arzak21st.loginapp.models.User;
import dev.arzak21st.loginapp.models.UserCredential;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveRepository {

    /* ========== VARIABLES ========== */
    boolean userIsSaved;
    boolean userCredentialIsSaved;

    SessionFactory sessionFactory;
    Session session;

    /* ========== CONSTRUCTORS ========== */
    public SaveRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /* ========== METHODS ========== */
    public boolean saveUser(User user) {

        userIsSaved = false;
        session = null;

        try {

            session = sessionFactory.openSession();
            session.beginTransaction();

            session.persist(user);
            session.getTransaction().commit();

            userIsSaved = true;
        }
        catch(Exception exception) {
            userIsSaved = false;
        }
        finally {
            session.close();
        }

        return userIsSaved;
    }

    public boolean saveUserCredential(UserCredential userCredential) {

        userCredentialIsSaved = false;
        session = null;

        try {

            session = sessionFactory.openSession();
            session.beginTransaction();

            session.persist(userCredential);
            session.getTransaction().commit();

            userCredentialIsSaved = true;
        }
        catch(Exception exception) {
            userCredentialIsSaved = false;
        }
        finally {
            session.close();
        }
        
        return userCredentialIsSaved;
    }
}
