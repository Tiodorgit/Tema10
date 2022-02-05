package bg.tu_varna.sit.inventory.data.repositories;

import java.util.List;
import java.util.Optional;

public interface DAORepository<T> {
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    Optional<T> getById(String id);
    Optional<T> getById(Integer id);
    List<T> getAll();
}
