package sn.isi.banqueapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Table(name = "ACCOUNTS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Account implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String numCard;
    @Column(length = 30)
    private String accountType;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private double solde;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Customer> customer = new ArrayList<Customer>();
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Operation> operations = new ArrayList<Operation>();
}
