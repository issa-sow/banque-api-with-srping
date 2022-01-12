package sn.isi.banqueapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Table(name = "OPERATIONS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Operation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255)
    private String label;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_operation;
    @ManyToOne
    private Account account;

    public void retrait(double montant) {
        this.setLabel("Retrait d'un montant de " + montant);
        this.account.setSolde(this.account.getSolde() - montant);
        this.date_operation = new Date();
    }
}