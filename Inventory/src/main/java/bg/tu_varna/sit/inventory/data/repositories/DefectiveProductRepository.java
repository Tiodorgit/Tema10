package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.DefectiveProductsEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DefectiveProductRepository implements DAORepository<DefectiveProductsEntity> {
    private static final Logger log = Logger.getLogger(DefectiveProductRepository.class);
    private static DefectiveProductRepository getInstance() {
        return DefectiveProductRepository.DefectiveProductRepositoryHolder.INSTANCE;
    }
    static class DefectiveProductRepositoryHolder {
        public static final DefectiveProductRepository INSTANCE = new DefectiveProductRepository();
    }
    @Override
    public void save(DefectiveProductsEntity obj) {
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
    public void update(DefectiveProductsEntity obj) {
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
    public void delete(DefectiveProductsEntity obj) {
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
    public Optional<DefectiveProductsEntity> getById(String id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        DefectiveProductsEntity defectiveProduct = new DefectiveProductsEntity();
        try {
            String jpql = "SELECT a FROM DefectiveProductsEntity a WHERE id =" + id.toString();
            defectiveProduct=session.createQuery(jpql, DefectiveProductsEntity.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(defectiveProduct);
    }

    @Override
    public Optional<DefectiveProductsEntity> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<DefectiveProductsEntity> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<DefectiveProductsEntity> defectiveProducts = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM DefectiveProductsEntity a";
            defectiveProducts.addAll(session.createQuery(jpql, DefectiveProductsEntity.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return defectiveProducts;
    }
}
