package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.Type;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TypeRepository implements DAORepository<Type> {
    private static final Logger log = Logger.getLogger(TypeRepository.class);
    private static TypeRepository getInstance() {
        return TypeRepository.TypeRepositoryHolder.INSTANCE;
    }
    static class TypeRepositoryHolder {
        public static final TypeRepository INSTANCE = new TypeRepository();
    }

    @Override
    public void save(Type obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Type saved successfully");
        }
        catch (Exception ex) {
            log.error("Type save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Type obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Type updated successfully");
        }
        catch (Exception ex) {
            log.error("Type update error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Type obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Type deleted successfully");
        }
        catch (Exception ex) {
            log.error("Type delete error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<Type> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Type> getById(Integer id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        Type type = new Type();
        try {
            String jpql = "SELECT a FROM Type a WHERE id =" + id.toString();
            type=session.createQuery(jpql, Type.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(type);
    }

    @Override
    public List<Type> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Type> types = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM Type a";
            types.addAll(session.createQuery(jpql, Type.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return types;
    }
}
