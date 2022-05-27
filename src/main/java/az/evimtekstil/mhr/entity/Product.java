package az.evimtekstil.mhr.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cost")
    private Float cost;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public Product() {
    }

    public Product(Integer productId, String name, Float cost, Category category) {
        this.productId = productId;
        this.name = name;
        this.cost = cost;
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
