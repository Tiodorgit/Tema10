package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.DefectiveProductsEntity;
import bg.tu_varna.sit.inventory.data.entities.ProductsEntity;
import bg.tu_varna.sit.inventory.data.entities.TypesEntity;
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
    private final DefectiveProductService defectiveProductService = DefectiveProductService.getInstance();
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

    public List<ProductsEntity> getAllProducts(LocalDate localDateStart, LocalDate localDateEnd){
        List<ProductsEntity> productsEntities = repository.getAll();
        List<ProductsEntity> productsDuringThePeriod = new ArrayList<>();
        for(ProductsEntity p: productsEntities) {
            if(p.getDateOfRegistration().isAfter(localDateStart) && p.getDateOfRegistration().isBefore(localDateEnd)) {
                productsDuringThePeriod.add(p);
            }
        }

        List<DefectiveProductsEntity> defectiveProductsEntities = defectiveProductService.getAllDefectiveProducts();
        for(DefectiveProductsEntity d: defectiveProductsEntities) {
            if(d.getDateOfRegistration().isAfter(localDateStart) && d.getDateOfRegistration().isBefore(localDateEnd) && d.getDateOfScrapping().isAfter(localDateStart) && d.getDateOfScrapping().isBefore(localDateEnd)) {
                ProductsEntity temp = new ProductsEntity(d.getInventoryNumber(),d.getDescription(),d.getTypesByTypeId(),d.getDateOfRegistration(),d.getWaranty(),d.getDegreeOfDepricationByDegreeOfDeprication(),d.getStatesByStateId(),d.getStatus(),d.getAccountablePersonsByAcountablePersonId());
                productsDuringThePeriod.add(temp);
            }
        }

        return productsDuringThePeriod;

    }

    public ObservableList<ProductListViewModel> getAllProductsDuringThePeriod(LocalDate localDateStart, LocalDate localDateEnd) {
        List<ProductsEntity> productsDuringThePeriod = getAllProducts(localDateStart,localDateEnd);

        return FXCollections.observableList(
                productsDuringThePeriod.stream().map(p -> new ProductListViewModel(
                        p.getInventoryNumber(),p.getDescription(),p.getTypesByTypeId(),p.getDateOfRegistration(),p.getWarranty(),p.getDegreeOfDepricationByDegreeOfDeprication(),p.getStatesByStateId(),p.getStatus(),p.getAccountablePersonsByAcountablePersonId()
                )).collect(Collectors.toList()));

    }

    public ObservableList<ProductListViewModel> getFullListOfProductsByType(LocalDate start, LocalDate end, TypesEntity type) {
        List<ProductsEntity> productsEntities = getAllProducts(start,end);
        List<ProductsEntity> productsByType = new ArrayList<>();
        for(ProductsEntity a: productsEntities) {
            if(a.getTypesByTypeId().equals(type)){
                productsByType.add(a);
            }
        }

        return FXCollections.observableList(
                productsByType.stream().map(p -> new ProductListViewModel(
                        p.getInventoryNumber(),p.getDescription(),p.getTypesByTypeId(),p.getDateOfRegistration(),p.getWarranty(),p.getDegreeOfDepricationByDegreeOfDeprication(),p.getStatesByStateId(),p.getStatus(),p.getAccountablePersonsByAcountablePersonId()
                )).collect(Collectors.toList()));
    }

    public ObservableList<ProductListViewModel> getAllAvailableProducts(LocalDate start, LocalDate end, boolean state) {
        List<ProductsEntity> productsEntities = getAllProducts(start,end);
        List<ProductsEntity> productsByType = new ArrayList<>();
        for(ProductsEntity a: productsEntities) {
            if(a.getStatus().equals(state)){
                productsByType.add(a);
            }
        }

        return FXCollections.observableList(
                productsByType.stream().map(p -> new ProductListViewModel(
                        p.getInventoryNumber(),p.getDescription(),p.getTypesByTypeId(),p.getDateOfRegistration(),p.getWarranty(),p.getDegreeOfDepricationByDegreeOfDeprication(),p.getStatesByStateId(),p.getStatus(),p.getAccountablePersonsByAcountablePersonId()
                )).collect(Collectors.toList()));
    }

    public static class ProductServiceHolder {
        public static final ProductService INSTANCE = new ProductService();
    }

}

