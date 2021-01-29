package ru.geekbrains.happy.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class HappyMarketApplication {
	// Домашнее задание:
	// 1. Доработайте корзину
	// 2. доп: Мысли по поводу того, как заказы должны храниться в БД
	// (например, как организовать сохранение цен товаров на момент покупки)

	public static void main(String[] args) {
		SpringApplication.run(HappyMarketApplication.class, args);
	}
}
