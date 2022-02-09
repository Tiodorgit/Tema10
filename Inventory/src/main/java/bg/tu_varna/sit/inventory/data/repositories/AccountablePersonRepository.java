package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class AccountablePersonRepository implements DAORepository<AccountablePersonsEntity>{
    private static final Logger log = Logger.getLogger(AccountablePersonsEntity.class);
    public static AccountablePersonRepository getInstance() {
        return AccountablePersonRepository.AccountablePersonHolder.INSTANCE;
    }

    private static class AccountablePersonHolder {
        public static final AccountablePersonRepository INSTANCE = new AccountablePersonRepository();
    }

    @Override
    public void save(AccountablePersonsEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Accountable person saved successfully");
        }
        catch (Exception ex) {
            log.error("Accountable person save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(AccountablePersonsEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Accountable person update successfully");
        }
        catch (Exception ex) {
            log.error("Accountable person update error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(AccountablePersonsEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Accountable person delete successfully");
        }
        catch (Exception ex) {
            log.error("Accountable person delete error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public AccountablePersonsEntity getById(int id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<AccountablePersonsEntity> user = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM AccountablePersonsEntity a WHERE id =" + id;
            user.addAll(session.createQuery(jpql, AccountablePersonsEntity.class).getResultList());
            log.info("Successfully got Accountable person");
        } catch (Exception e) {
            log.error("Get accountable person error: " + e.getMessage());
        } finally {
            transaction.commit();
            session.close();
        }
        return user.get(0);
    }

    @Override
    public List<AccountablePersonsEntity> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<AccountablePersonsEntity> users = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM AccountablePersonsEntity a ";
            users.addAll(session.createQuery(jpql, AccountablePersonsEntity.class).getResultList());
            log.info("Successfully got all admins");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Get Accountable person error: " +e.getMessage());
        } finally {
            transaction.commit();
            session.close();
        }
        return users;
    }
}
