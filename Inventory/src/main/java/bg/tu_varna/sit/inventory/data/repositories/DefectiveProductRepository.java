package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.DefectiveProduct;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DefectiveProductRepository implements DAORepository<DefectiveProduct> {
    private static final Logger log = Logger.getLogger(DefectiveProductRepository.class);
    private static DefectiveProductRepository getInstance() {
        return DefectiveProductRepository.DefectiveProductRepositoryHolder.INSTANCE;
    }
    static class DefectiveProductRepositoryHolder {
        public static final DefectiveProductRepository INSTANCE = new DefectiveProductRepository();
    }
    @Override
    public void save(DefectiveProduct obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Defective product saved successfully");
        }
        catch (Exception ex) {
            log.error("Defective product save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(DefectiveProduct obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Defective product updated successfully");
        }
        catch (Exception ex) {
            log.error("Defective product update error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(DefectiveProduct obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Defective product deleted successfully");
        }
        catch (Exception ex) {
            log.error("Defective product delete error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<DefectiveProduct> getById(String id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        DefectiveProduct defectiveProduct = new DefectiveProduct();
        try {
            String jpql = "SELECT a FROM DefectiveProduct a WHERE id =" + id.toString();
            defectiveProduct=session.createQuery(jpql, DefectiveProduct.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(defectiveProduct);
    }

    @Override
    public Optional<DefectiveProduct> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<DefectiveProduct> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<DefectiveProduct> defectiveProducts = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM DefectiveProduct a";
            defectiveProducts.addAll(session.createQuery(jpql, DefectiveProduct.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return defectiveProducts;
    }
}
