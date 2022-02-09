package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.TypesEntity;
import bg.tu_varna.sit.inventory.data.repositories.TypeRepository;
import bg.tu_varna.sit.inventory.presentation.models.TypeListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class TypeService {
    private final TypeRepository repository = TypeRepository.getInstance();
    private static final Logger log = Logger.getLogger(TypeService.class);
    public static TypeService getInstance() {
        return TypeServiceHolder.INSTANCE;
    }

    public ObservableList<TypeListViewModel> getAllTypes() {
        List<TypesEntity> typesEntities = repository.getAll();

        return FXCollections.observableList(
                typesEntities.stream().map(s -> new TypeListViewModel(
                        s.getType()
                )).collect(Collectors.toList()));
    }

    public TypesEntity listViewToEntity(TypeListViewModel a) {
        TypesEntity temp = new TypesEntity(a.getType());
        List<TypesEntity> types = repository.getAll();
        for (TypesEntity type:types) {
            if(type.equals(temp))
                return type;
        }
        return null;
    }

    private static class TypeServiceHolder {
        public static final TypeService INSTANCE = new TypeService();
    }

}
