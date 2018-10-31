package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class ProductJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column
    private Long price;

    @Column
    private Long articale;

    @Column
    private Long warehouse;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_category"))
    private Set<CategoryJPA> categories;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "product_orders",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_order"))
    private Set<OrderJPA> orders;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getArticale() {
        return articale;
    }

    public void setArticale(Long articale) {
        this.articale = articale;
    }

    public Long getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Long warehouse) {
        this.warehouse = warehouse;
    }

    public Set<CategoryJPA> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryJPA> categories) {
        this.categories = categories;
    }

    public Set<OrderJPA> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderJPA> orders) {
        this.orders = orders;
    }
}
