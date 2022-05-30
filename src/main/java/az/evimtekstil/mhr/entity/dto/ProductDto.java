package az.evimtekstil.mhr.entity.dto;

public class ProductDto {

    private Integer productId;
    private String name;
    private Float cost;

    public ProductDto() {
    }

    public ProductDto(Integer productId, String name, Float cost) {
        this.productId = productId;
        this.name = name;
        this.cost = cost;
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
}
