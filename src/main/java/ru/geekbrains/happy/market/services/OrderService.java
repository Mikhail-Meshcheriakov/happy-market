package ru.geekbrains.happy.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.happy.market.beans.Cart;
import ru.geekbrains.happy.market.model.Order;
import ru.geekbrains.happy.market.model.OrderItem;
import ru.geekbrains.happy.market.repositories.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final Cart cart;

    public Order save(Order order) {
        Order currentOrder;
        List<OrderItem> orderItems = cart.getItems();
        if (!orderItems.isEmpty()) {
            currentOrder = orderRepository.save(order);
            for (int i = 0; i < orderItems.size(); i++) {
                orderItems.get(i).setOrder(currentOrder);
                orderItemService.save(orderItems.get(i));
            }
            cart.clear();
            return currentOrder;
        } else {
            return order;
        }
    }
}
