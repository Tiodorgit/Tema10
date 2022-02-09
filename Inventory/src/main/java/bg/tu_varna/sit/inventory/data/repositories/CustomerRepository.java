package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.CustomersEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements DAORepository<CustomersEntity>{
    private static final Logger log =Logger.getLogger(CustomerRepository.class);
    public static CustomerRepository getInstance() { return CustomerRepository.CustomerRepositoryHolder.INSTANCE; }
    static class CustomerRepositoryHolder {
        public static final CustomerRepository INSTANCE = new CustomerRepository();
    }

    @Override
    public void save(CustomersEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Customer saved successfully");
        }
        catch (Exception ex) {
            log.error("Customer save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(CustomersEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Customer saved successfully");
        }
        catch (Exception ex) {
            log.error("Customer save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(CustomersEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Customer saved successfully");
        }
        catch (Exception ex) {
            log.error("Customer save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public CustomersEntity getById(int id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        List<CustomersEntity> customer = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM CustomersEntity a WHERE id =" + id;
            customer.addAll(session.createQuery(jpql, CustomersEntity.class).getResultList());
            log.info("Successfully got Customer!");
        } catch (Exception e) {
            log.error("Get Customer error: " + e.getMessage());
        } finally {
            transaction.commit();
            session.close();
        }
        return customer.get(0);
    }

    @Override
    public List<CustomersEntity> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<CustomersEntity> customerList = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM CustomersEntity a";
            customerList.addAll(session.createQuery(jpql, CustomersEntity.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return customerList;
    }
}
