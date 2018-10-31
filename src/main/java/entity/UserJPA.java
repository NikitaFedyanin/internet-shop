package entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String adress;

    @Column
    private String kind_of_payment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getKind_of_payment() {
        return kind_of_payment;
    }

    public void setKind_of_payment(String kind_of_payment) {
        this.kind_of_payment = kind_of_payment;
    }
}
