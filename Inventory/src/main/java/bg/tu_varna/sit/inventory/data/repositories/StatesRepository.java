package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.DefectiveProductsEntity;
import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class StatesRepository implements DAORepository<StatesEntity> {
    private static final Logger log = Logger.getLogger(StatesRepository.class);
    public static StatesRepository getInstance() {
        return StatesRepository.StatesRepositoryHolder.INSTANCE;
    }
    static class StatesRepositoryHolder {
        public static final StatesRepository INSTANCE = new StatesRepository();
    }

    @Override
    public void save(StatesEntity obj) {
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
    public void update(StatesEntity obj) {
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
    public void delete(StatesEntity obj) {
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
    public StatesEntity getById(int id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        List<StatesEntity> states = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM StatesEntity a WHERE id =" + id;
            states.addAll(session.createQuery(jpql, StatesEntity.class).getResultList());
            log.info("Successfully got State!");
        } catch (Exception e) {
            log.error("Get State error: " + e.getMessage());
        } finally {
            transaction.commit();
            session.close();
        }
        return states.get(0);
    }

    @Override
    public List<StatesEntity> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<StatesEntity> states = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM StatesEntity a";
            states.addAll(session.createQuery(jpql, StatesEntity.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
            return states;
    }
}
