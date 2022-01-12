package sn.isi.banqueapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.banqueapi.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
