package test.spring.data.oneone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Listing implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(columnDefinition= "DECIMAL(10,2)")
    private double price;
    @OneToOne
    @PrimaryKeyJoinColumn
    private ListingLocation listingLocation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ListingLocation getListingLocation() {
        return listingLocation;
    }

    public void setListingLocation(ListingLocation listingLocation) {
        this.listingLocation = listingLocation;
    }
}