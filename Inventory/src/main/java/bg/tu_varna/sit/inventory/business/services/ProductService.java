package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.ProductsEntity;
import bg.tu_varna.sit.inventory.data.repositories.ProductRepository;
import bg.tu_varna.sit.inventory.presentation.models.ProductListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class ProductService {
    private final ProductService productService = ProductService.getInstance();
    private static final Logger log = Logger.getLogger(ProductService.class);
    private final ProductRepository repository = ProductRepository.getInstance();
    public static ProductService getInstance() {
        return ProductServiceHolder.INSTANCE;
    }

    /*public ObservableList<ProductListViewModel> getAllProductsList(LocalDate myFromDate, LocalDate myToDate) {
        List<ProductsEntity> products = ProductRepository.getAll();
        List<ProductsEntity> productsInPeriod = new ArrayList<>();
        for(ProductsEntity p: products){
            if(p.getDateOfRegistration().isAfter(myFromDate) && p.getDateOfRegistration().isBefore(myToDate));
            {
                productsInPeriod.add(p);
            }
        }
        return FXCollections.observableList(
                productsInPeriod.stream().map(p -> new ProductListViewModel(
                        p.getInventoryNumber(),p.getDescription(),p.getTypesByTypeId(),p.isProdStatus(),p.getExploatationStart(),p.getProductValue(),p.getByMol(),p.getByAmortization(),p.getDiscardDate()
                )).collect(Collectors.toList()));

    }*/


    public void addProduct(ProductListViewModel p) {
        ProductsEntity products = new ProductsEntity(p.getDescription(),p.getTypeID(),p.getDateOfRegistration(),p.getWarranty(),p.getDegreeOfDepreciation(),p.getStateID(),p.isStatus(),p.getAccountablePersons());
        repository.save(products);
    }

    public ProductsEntity listViewToEntity(ProductListViewModel p) {
        ProductsEntity temp = new ProductsEntity(p.getInventoryNumber(),p.getDescription());
        List<ProductsEntity> products = repository.getAll();
        for (ProductsEntity product: products) {
            if(product.equals(temp))
                return product;
        }
        return null;
    }

    public ProductsEntity getProductByID(int num) {
        ProductsEntity products = repository.getById(num);
        return products;
    }

    public void changeStatus(ProductsEntity product) {
        if(product.getStatus())
            product.setStatus(false);
        else
            product.setStatus(true);
        repository.update(product);
    }

    public ObservableList<ProductListViewModel> getAllProducts() {
        List<ProductsEntity> productsEntities = repository.getAll();
        return FXCollections.observableList(
                productsEntities.stream().map(p -> new ProductListViewModel(
                        p.getInventoryNumber(),p.getDescription()
                )).collect(Collectors.toList()));
    }

    public void deleteProduct(ProductListViewModel products) {
        ProductsEntity product = getProductByID(products.getInventoryNumber());
        product.setDescription(null);
        product.setTypesByTypeId(null);
        product.setDateOfRegistration(null);
        product.setWarranty(null);
        product.setDegreeOfDepricationByDegreeOfDeprication(null);
        product.setStatesByStateId(null);
        product.setStatus(null);
        product.setAccountablePersonsByAcountablePersonId(null);
        repository.update(product);
    }

    public ObservableList<ProductListViewModel> getFullProducts() {
        List<ProductsEntity> productsEntities = repository.getAll();

        return FXCollections.observableList(
                productsEntities.stream().map(p -> new ProductListViewModel(
                        p.getInventoryNumber(),p.getDescription(),p.getTypesByTypeId(),p.getDateOfRegistration(),p.getWarranty(),p.getDegreeOfDepricationByDegreeOfDeprication(),p.getStatesByStateId(),p.getStatus(),p.getAccountablePersonsByAcountablePersonId()
                )).collect(Collectors.toList()));
    }

    public static class ProductServiceHolder {
        public static final ProductService INSTANCE = new ProductService();
    }

    public double degreeOfDepreciation(LocalDate date, int years){
        double a =100;
        if((LocalDate.now().getYear()-date.getYear()) == years){
            if(LocalDate.now().getMonth().compareTo(date.getMonth())==0 || LocalDate.now().getMonth().compareTo(date.getMonth())==-1){
                return (a/years)*(years-1);
            }
        } else {
            if((LocalDate.now().getYear()-date.getYear()) < years) {
                return (a/years)*(LocalDate.now().getYear()-date.getYear());
            }
        }
        return 100;
    }
}

