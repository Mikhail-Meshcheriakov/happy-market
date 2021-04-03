package ru.geekbrains.happy.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@PropertySource("classpath:secured.properties")
public class HappyMarketApplication {
	// Домашнее задание:
	// - Поискать баги при работе с корзиной
	// - Сдать текстовый отчет: багов нет, баги есть: вот такие
	// - * Предложить починку этих багов

	public static void main(String[] args) {
		SpringApplication.run(HappyMarketApplication.class, args);
	}
}
