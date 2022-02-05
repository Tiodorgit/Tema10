package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "DefectiveProducts")
@Entity
public class DefectiveProduct implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "inventoryNumber", nullable = false)
    private String inventoryNumber;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "typeID", nullable = false)
    private Type typeID;

    @Column(name = "dateOfRegistration")
    private Date dateOfRegistration;

    @Column(name = "warranty")
    private int warranty;

    @Column(name = "degreeOfDepreciation")
    private int degreeOfDepreciation;

    @ManyToOne
    @JoinColumn(name = "stateID", nullable = false)
    private States stateID;

    @Column(name = "status")
    private int status;

    @Column(name = "dateOfScrapping")
    private Date dateOfScrapping;

    public DefectiveProduct(String inventoryNumber, String description, Type typeID, Date dateOfRegistration, int warranty, int degreeOfDepreciation, States stateID, int status, Date dateOfScrapping) {
        this.inventoryNumber = inventoryNumber;
        this.description = description;
        this.typeID = typeID;
        this.dateOfRegistration = dateOfRegistration;
        this.warranty = warranty;
        this.degreeOfDepreciation = degreeOfDepreciation;
        this.stateID = stateID;
        this.status = status;
        this.dateOfScrapping = dateOfScrapping;
    }

    public DefectiveProduct() {

    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getTypeID() {
        return typeID;
    }

    public void setTypeID(Type typeID) {
        this.typeID = typeID;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public int getDegreeOfDepreciation() {
        return degreeOfDepreciation;
    }

    public void setDegreeOfDepreciation(int degreeOfDepreciation) {
        this.degreeOfDepreciation = degreeOfDepreciation;
    }

    public States getStateID() {
        return stateID;
    }

    public void setStateID(States stateID) {
        this.stateID = stateID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDateOfScrapping() {
        return dateOfScrapping;
    }

    public void setDateOfScrapping(Date dateOfScrapping) {
        this.dateOfScrapping = dateOfScrapping;
    }

    @Override
    public String toString() {
        return "DefectiveProduct{" +
                "inventoryNumber='" + inventoryNumber + '\'' +
                ", description='" + description + '\'' +
                ", typeID=" + typeID +
                ", dateOfDepreciation=" + dateOfRegistration +
                ", warranty=" + warranty +
                ", degreeOfDepreciation=" + degreeOfDepreciation +
                ", stateID=" + stateID +
                ", status=" + status +
                ", dateOfScrapping=" + dateOfScrapping +
                '}';
    }
}
