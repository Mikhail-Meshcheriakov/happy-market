package ru.geekbrains.happy.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.happy.market.model.Cart;
import ru.geekbrains.happy.market.model.Product;
import ru.geekbrains.happy.market.model.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
    @Query("select c from Cart c where c.user.id = ?1")
    Optional<Cart> findByUserId(Long id);
}
