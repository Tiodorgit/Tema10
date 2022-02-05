package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.DefectiveProduct;
import bg.tu_varna.sit.inventory.data.entities.States;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class StatesRepository implements DAORepository<States> {
    private static final Logger log = Logger.getLogger(StatesRepository.class);
    private static StatesRepository getInstance() {
        return StatesRepository.StatesRepositoryHolder.INSTANCE;
    }
    static class StatesRepositoryHolder {
        public static final StatesRepository INSTANCE = new StatesRepository();
    }

    @Override
    public void save(States obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("States saved successfully");
        }
        catch (Exception ex) {
            log.error("States save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(States obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("States updated successfully");
        }
        catch (Exception ex) {
            log.error("States update error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(States obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("States deleted successfully");
        }
        catch (Exception ex) {
            log.error("States delete error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<States> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<States> getById(Integer id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        States states = new States();
        try {
            String jpql = "SELECT a FROM States a WHERE id =" + id.toString();
            states=session.createQuery(jpql, States.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(states);
    }

    @Override
    public List<States> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<States> states = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM States a";
            states.addAll(session.createQuery(jpql, States.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
            return states;
    }
}
