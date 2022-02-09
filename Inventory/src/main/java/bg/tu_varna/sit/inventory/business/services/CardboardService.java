package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.CardboardsEntity;
import bg.tu_varna.sit.inventory.data.entities.ProductsEntity;
import bg.tu_varna.sit.inventory.data.repositories.CardboardRepository;
import bg.tu_varna.sit.inventory.presentation.models.CardboardListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class CardboardService {
    private final CardboardRepository repository = CardboardRepository.getInstance();
    private static final Logger log = Logger.getLogger(CardboardService.class);
    public static CardboardService getInstance() {
        return CardboardServiceHolder.INSTANCE;
    }
    private final ProductService productService = ProductService.getInstance();

    public int addCardboard(CardboardListViewModel a) {
        CardboardsEntity cardboardsEntity = new CardboardsEntity(a.getCustomer(),a.getProduct(),a.getDateTaken(),a.getDateReturn());
        int num;
        ProductsEntity products;
        num = cardboardsEntity.getProductsByProductId().getInventoryNumber();
        products = productService.getProductByID(num);
        if(!products.getStatus())
            return 0;
        repository.save(cardboardsEntity);
        productService.changeStatus(products);
        return 1;
    }

    public ObservableList<CardboardListViewModel> getAllBoards() {
        List<CardboardsEntity> customerBoards = repository.getAll();

        return FXCollections.observableList(
                customerBoards.stream().map(cb -> new CardboardListViewModel(
                        cb.getCustomersByCustomerId(),cb.getProductsByProductId(),cb.getDateTaken(),cb.getDateReturn()
                )).collect(Collectors.toList()));
    }

    public boolean returnProduct (CardboardListViewModel a) {
        CardboardsEntity cardboardsEntity = new CardboardsEntity(a.getIdCustomerBoard(), a.getCustomer(), a.getProduct(), a.getDateTaken(), a.getDateReturn());
        List<CardboardsEntity> cardboardsEntities = repository.getAll();
        for(CardboardsEntity c:cardboardsEntities){
            if(c.equals(cardboardsEntity) && c.getDateReturn() == null) {
                cardboardsEntity.setId(c.getId());
                repository.update(cardboardsEntity);
                ProductsEntity products = cardboardsEntity.getProductsByProductId();
                productService.changeStatus(products);
                return true;
            }
        }
        return false;
    }

    private static class CardboardServiceHolder {
        public static final CardboardService INSTANCE = new CardboardService();
    }
}
