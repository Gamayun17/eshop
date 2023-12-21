package by.it.academy.data.pojo;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_PRODUCT_SPECIFICATION")
public class ProductSpecification {

    @Id
    private int id;

    @Column(name = "product_name", length = 150, nullable = false)
    private String productName;

    @Column(name = "product_price")
    private double productPricel;

    @ManyToMany(mappedBy = "products", cascade = {
            CascadeType.ALL
    })
    private List<Promo> promoList;

    public ProductSpecification() {
    }

    public ProductSpecification(int id, String productName, double productPricel) {
        this.id = id;
        this.productName = productName;
        this.productPricel = productPricel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPricel;
    }

    public void setProductPrice(double productPrice) {
        this.productPricel = productPrice;
    }

    public List<Promo> getPromoList() {
        return promoList;
    }

    public void setPromoList(List<Promo> promoList) {
        this.promoList = promoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSpecification that = (ProductSpecification) o;

        if (id != that.id) return false;
        if (Double.compare(that.productPricel, productPricel) != 0) return false;
        return Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        temp = Double.doubleToLongBits(productPricel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}