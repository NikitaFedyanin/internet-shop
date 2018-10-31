package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrderJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

   @OneToOne
   @JoinColumn(name = "user_id")
    private UserJPA userJPA;

    @Column
    private Long price;

    @OneToOne
    @JoinColumn(name = "status_id")
    private StatusJPA status;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "products_orders",
    joinColumns = @JoinColumn(name = "id_order"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<ProductJPA> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserJPA getUserJPA() {
        return userJPA;
    }

    public void setUserJPA(UserJPA userJPA) {
        this.userJPA = userJPA;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public StatusJPA getStatus() {
        return status;
    }

    public void setStatus(StatusJPA status) {
        this.status = status;
    }

    public Set<ProductJPA> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductJPA> products) {
        this.products = products;
    }
}
