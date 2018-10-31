package entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long id_parent;

    @Column
    private String category;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "product_categories",
    joinColumns = @JoinColumn(name = "id_category"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private Set<ProductJPA> products;

    @OneToMany
    @JoinColumn(name = "id_parent")
    private Set<CategoryJPA> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_parent() {
        return id_parent;
    }

    public void setId_parent(Long id_parent) {
        this.id_parent = id_parent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<ProductJPA> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductJPA> products) {
        this.products = products;
    }

    public Set<CategoryJPA> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryJPA> categories) {
        this.categories = categories;
    }
}
