package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import bg.tu_varna.sit.inventory.data.repositories.StatesRepository;
import bg.tu_varna.sit.inventory.presentation.models.StateListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.TypeListViewModel;
import org.apache.log4j.Logger;

import java.util.List;

public class StateService {
    private final StatesRepository repository = StatesRepository.getInstance();
    private static final Logger log = Logger.getLogger(StateService.class);
    public static StateService getInstance() {
        return StateServiceHolder.INSTANCE;
    }

    public StatesEntity listViewToEntity(StateListViewModel a) {
        StatesEntity temp = new StatesEntity(a.getState());
        List<StatesEntity> states = repository.getAll();
        for(StatesEntity state:states) {
            if(state.equals(temp))
                return state;
        }
        return null;
    }

    private static class StateServiceHolder {
        public static final StateService INSTANCE = new StateService();
    }
}
