package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.Customer;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements DAORepository<Customer>{
    private static final Logger log =Logger.getLogger(CustomerRepository.class);
    private static CustomerRepository getInstance() { return CustomerRepository.CustomerRepositoryHolder.INSTANCE; }
    static class CustomerRepositoryHolder {
        public static final CustomerRepository INSTANCE = new CustomerRepository();
    }

    @Override
    public void save(Customer obj) {
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
    public void update(Customer obj) {
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
    public void delete(Customer obj) {
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
    public Optional<Customer> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> getById(Integer id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        Customer customer = new Customer();
        try {
            String jpql = "SELECT a FROM Customer a WHERE id =" + id.toString();
            customer=session.createQuery(jpql, Customer.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(customer);
    }

    @Override
    public List<Customer> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customerList = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM Customer a";
            customerList.addAll(session.createQuery(jpql, Customer.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return customerList;
    }
}
