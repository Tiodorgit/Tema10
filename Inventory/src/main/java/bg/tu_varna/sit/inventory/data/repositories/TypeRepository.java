package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.TypesEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TypeRepository implements DAORepository<TypesEntity> {
    private static final Logger log = Logger.getLogger(TypeRepository.class);
    public static TypeRepository getInstance() {
        return TypeRepository.TypeRepositoryHolder.INSTANCE;
    }
    static class TypeRepositoryHolder {
        public static final TypeRepository INSTANCE = new TypeRepository();
    }

    @Override
    public void save(TypesEntity obj) {
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
    public void update(TypesEntity obj) {
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
    public void delete(TypesEntity obj) {
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
    public TypesEntity getById(int id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        List<TypesEntity> type = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM TypesEntity a WHERE id =" + id;
            type.addAll(session.createQuery(jpql, TypesEntity.class).getResultList());
            log.info("Successfully got Type!");
        } catch (Exception e) {
            log.error("Got Type error: " + e.getMessage());
        } finally {
            transaction.commit();
            session.close();
        }
        return type.get(0);
    }

    @Override
    public List<TypesEntity> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<TypesEntity> types = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM TypesEntity a";
            types.addAll(session.createQuery(jpql, TypesEntity.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return types;
    }
}
