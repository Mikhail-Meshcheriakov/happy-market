package ru.geekbrains.happy.market.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.happy.market.model.Order;
import ru.geekbrains.happy.market.services.OrderService;
import ru.geekbrains.happy.market.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @GetMapping
    public void save(Principal principal) {
        orderService.save(new Order(userService.findByUsername(principal.getName()).get()));
    }
}
