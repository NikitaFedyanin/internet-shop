package entity;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @SequenceGenerator(name = "status_id_seq", sequenceName = "status_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_id_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private String sysname;

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

    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname;
    }



}
