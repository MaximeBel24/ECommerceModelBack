package fr.doranco.nomad_odyssey.repositories;

import fr.doranco.nomad_odyssey.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
