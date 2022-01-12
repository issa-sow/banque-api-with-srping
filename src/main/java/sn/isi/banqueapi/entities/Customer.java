package sn.isi.banqueapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "CUSTOMERS")
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String lastName;
    @Column(length = 30)
    private String firstName;
    @Column(length = 30)
    private String email;
    @ManyToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Account> accounts = new ArrayList<Account>();
}
