package fr.doranco.nomad_odyssey.repositories;

import fr.doranco.nomad_odyssey.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
