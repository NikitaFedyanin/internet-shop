package entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;

    @Column
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", kind_of_payment='" + kind_of_payment + '\'' +
                '}';
    }
}
