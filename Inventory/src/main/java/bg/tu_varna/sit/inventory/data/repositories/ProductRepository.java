package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.DefectiveProductsEntity;
import bg.tu_varna.sit.inventory.data.entities.ProductsEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements DAORepository<ProductsEntity> {
    private static final Logger log = Logger.getLogger(ProductRepository.class);
    private static ProductRepository getInstance() {
        return ProductRepository.ProductRepositoryHolder.INSTANCE;
    }
    static class ProductRepositoryHolder {
        public static final ProductRepository INSTANCE = new ProductRepository();
    }

    @Override
    public void save(ProductsEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Product saved successfully");
        }
        catch (Exception ex) {
            log.error("Product save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(ProductsEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Product updated successfully");
        }
        catch (Exception ex) {
            log.error("Product update error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(ProductsEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Product deleted successfully");
        }
        catch (Exception ex) {
            log.error("Product delete error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<ProductsEntity> getById(String id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        ProductsEntity product = new ProductsEntity();
        try {
            String jpql = "SELECT a FROM DefectiveProduct a WHERE id =" + id.toString();
            product=session.createQuery(jpql, ProductsEntity.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(product);
    }

    @Override
    public Optional<ProductsEntity> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<ProductsEntity> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<ProductsEntity> products = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM ProductsEntity a";
            products.addAll(session.createQuery(jpql, ProductsEntity.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return products;
    }
}
