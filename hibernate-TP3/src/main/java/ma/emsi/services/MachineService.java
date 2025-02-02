package ma.emsi.services;

import ma.emsi.dao.IDao;
import ma.emsi.entities.Machine;
import ma.emsi.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class MachineService implements IDao<Machine> {

    @Override
    public boolean create(Machine o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            etat = false;
        } finally {
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean delete(Machine o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            etat = false;
        } finally {
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public boolean update(Machine o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
            etat = false;
        } finally {
            if(session != null)
                session.close();
        }
        return etat;
    }

    @Override
    public Machine findById(int id) {
        Session session = null;
        Transaction tx = null;
        Machine machine = null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            machine = (Machine) session.get(Machine.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return machine;
    }

    @Override
    public List<Machine> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Machine> machines = null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            machines = session.createQuery("from Machine ").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return machines;
    }


    public List<Machine> findBetweenDate(Date d1, Date d2) {
        Session session = null;
        Transaction tx = null;
        List<Machine> machines = null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            machines = session.getNamedQuery("findBetweenDate")
                    .setParameter("d1", d1)
                    .setParameter("d2", d2)
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return machines;
    }

}
