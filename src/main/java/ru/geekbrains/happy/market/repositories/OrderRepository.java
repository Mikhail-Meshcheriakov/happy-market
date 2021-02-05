package ru.geekbrains.happy.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.happy.market.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
