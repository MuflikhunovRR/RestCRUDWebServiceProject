package ru.gotoqa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.gotoqa.model.Bic;

import java.util.List;

/**
 * @author Muflikhunov Roman
 */
public class BicDaoImpl implements BicDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(BicDaoImpl.class);

    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBic(Bic bic) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(bic);
        LOGGER.info("Bic add. " + bic);
    }

    @Override
    public void removeBic(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Bic bic = (Bic) session.load(Bic.class, new Integer(id));

        if(bic!=null){
            session.delete(bic);
        }
        LOGGER.info("Bic removed. " + bic);
    }

    @Override
    public void updateBic(Bic bic) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(bic);
        LOGGER.info("Bic update. " + bic);
    }

    @Override
    public Bic getBicById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Bic bic = (Bic) session.load(Bic.class, new Integer(id));
        LOGGER.info("Bic upload. " + bic);

        return bic;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Bic> listBics() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Bic> bicList = session.createQuery("from Bic").list();

        for(Bic bic : bicList){
            LOGGER.info("Bic's: " + bic);
        }

        return bicList;
        }
}
