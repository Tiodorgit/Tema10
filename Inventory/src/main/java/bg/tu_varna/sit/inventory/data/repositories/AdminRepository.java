package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.Admin;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AdminRepository implements DAORepository<Admin>{
    private static final Logger log = Logger.getLogger(AdminRepository.class);
    public static AdminRepository getInstance() { return AdminRepository.UserRepositoryHolder.INSTANCE; }

    private static class UserRepositoryHolder {
        public static final AdminRepository INSTANCE = new AdminRepository();
    }

    @Override
    public void save(Admin obj) {
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
    public void update(Admin obj) {
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
    public void delete(Admin obj) {
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
    public Optional getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional getById(Integer id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        Admin user = new Admin();
        try {
            String jpql = "SELECT a FROM Admin a WHERE id =" + id.toString();
            user=session.createQuery(jpql, Admin.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(user);
    }

    @Override
    public List getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Admin> users = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM Admin a ";
            users.addAll(session.createQuery(jpql, Admin.class).getResultList());
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
