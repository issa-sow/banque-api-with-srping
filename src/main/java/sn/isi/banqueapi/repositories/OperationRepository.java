package sn.isi.banqueapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.banqueapi.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
