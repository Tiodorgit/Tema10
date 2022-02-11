package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.AdminsEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AdminRepository implements DAORepository<AdminsEntity>{
    private static final Logger log = Logger.getLogger(AdminRepository.class);
    public static AdminRepository getInstance() { return AdminRepository.UserRepositoryHolder.INSTANCE; }

    private static class UserRepositoryHolder {
        public static final AdminRepository INSTANCE = new AdminRepository();
    }

    @Override
    public void save(AdminsEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Admin saved successfully");
        }
        catch (Exception ex) {
            log.error("Admin save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(AdminsEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("User update successfully");
        }
        catch (Exception ex) {
            log.error("User update error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(AdminsEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("User delete successfully");
        }
        catch (Exception ex) {
            log.error("User delete error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public AdminsEntity getById(int id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<AdminsEntity> user = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM AdminsEntity a WHERE id =" + id;
            user.addAll(session.createQuery(jpql, AdminsEntity.class).getResultList());
            log.info("Successfully got admin!");
        } catch (Exception e) {
            log.error("Get Admin error: " + e.getMessage());
        } finally {
            transaction.commit();
            session.close();
        }
        return user.get(0);
    }

    @Override
    public List<AdminsEntity> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<AdminsEntity> users = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM AdminsEntity a ";
            users.addAll(session.createQuery(jpql, AdminsEntity.class).getResultList());
            log.info("Successfully got all admins");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Get Admin error: " +e.getMessage());
        } finally {
            transaction.commit();
            session.close();
        }
        return users;
    }


}
