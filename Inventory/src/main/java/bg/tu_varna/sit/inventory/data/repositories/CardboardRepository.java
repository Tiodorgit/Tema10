package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.Cardboard;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CardboardRepository implements DAORepository<Cardboard>{
    private static final Logger log =Logger.getLogger(CardboardRepository.class);

    private static CardboardRepository getInstance() { return CardboardRepository.CardboardRepositoryHolder.INSTANCE; }
    static class CardboardRepositoryHolder {
        public static final CardboardRepository INSTANCE = new CardboardRepository();
    }

    @Override
    public void save(Cardboard obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Cardboard saved successfully");
        }
        catch (Exception ex) {
            log.error("Cardboard save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Cardboard obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Cardboard update successfully");
        }
        catch (Exception ex) {
            log.error("Cardboard update error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Cardboard obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Cardboard delete successfully");
        }
        catch (Exception ex) {
            log.error("Cardboard delete error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<Cardboard> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Cardboard> getById(Integer id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        Cardboard cardboard = new Cardboard();
        try {
            String jpql = "SELECT a FROM Cardboard a WHERE id =" + id.toString();
            cardboard = session.createQuery(jpql, Cardboard.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(cardboard);
    }

    @Override
    public List<Cardboard> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Cardboard> cardboardList = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM Cardboard a";
            cardboardList.addAll(session.createQuery(jpql, Cardboard.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return cardboardList;
    }
}
