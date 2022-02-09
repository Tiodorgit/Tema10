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
    public static DefectiveProductRepository getInstance() {
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
            log.error("Defective product save error " + ex.getMessage());
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
    public DefectiveProductsEntity getById(int id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        List<DefectiveProductsEntity> defectiveProduct = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM DefectiveProductsEntity a WHERE id =" + id;
            defectiveProduct.addAll(session.createQuery(jpql, DefectiveProductsEntity.class).getResultList());
            log.info("Successfully got Defective Product!");
        } catch (Exception e) {
            log.error("Get Defective Product error: " + e.getMessage());
        } finally {
            transaction.commit();
            session.close();
        }
        return defectiveProduct.get(0);
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
