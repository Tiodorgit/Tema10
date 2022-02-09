package bg.tu_varna.sit.inventory.data.repositories;

import bg.tu_varna.sit.inventory.data.access.Connection;
import bg.tu_varna.sit.inventory.data.entities.DefectiveProductsEntity;
import bg.tu_varna.sit.inventory.data.entities.DegreeOfDepricationEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class DegreeOfDepricationRepository implements DAORepository<DegreeOfDepricationEntity>{
    private static final Logger log = Logger.getLogger(DegreeOfDepricationRepository.class);
    public static DegreeOfDepricationRepository getInstance() {
        return DegreeOfDepricationRepository.DegreeOfDepricationRepositoryHolder.INSTANCE;
    }
    static class DegreeOfDepricationRepositoryHolder {
        public static final DegreeOfDepricationRepository INSTANCE = new DegreeOfDepricationRepository();
    }
    @Override
    public void save(DegreeOfDepricationEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
            log.info("Degree Of Deprication saved successfully");
        }
        catch (Exception ex) {
            log.error("Degree Of Deprication save error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void update(DegreeOfDepricationEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
            log.info("Degree Of Deprication updated successfully");
        }
        catch (Exception ex) {
            log.error("Degree Of Deprication update error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(DegreeOfDepricationEntity obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Degree Of Deprication deleted successfully");
        }
        catch (Exception ex) {
            log.error("Degree Of Deprication delete error" + ex.getMessage());
        }
        finally {
            transaction.commit();
        }
    }

    @Override
    public DegreeOfDepricationEntity getById(int id) {
        Session session =Connection.openSession();
        Transaction transaction =session.beginTransaction();
        List<DegreeOfDepricationEntity> defectiveProduct = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM DegreeOfDepricationEntity a WHERE id =" + id;
            defectiveProduct.addAll(session.createQuery(jpql, DegreeOfDepricationEntity.class).getResultList());
            log.info("Successfully got Degree Of Deprication!");
        } catch (Exception e) {
            log.error("Get Degree Of Deprication error: " + e.getMessage());
        } finally {
            transaction.commit();
            session.close();
        }
        return defectiveProduct.get(0);
    }

    @Override
    public List<DegreeOfDepricationEntity> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<DegreeOfDepricationEntity> defectiveProducts = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM DegreeOfDepricationEntity a";
            defectiveProducts.addAll(session.createQuery(jpql, DegreeOfDepricationEntity.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return defectiveProducts;
    }
}
