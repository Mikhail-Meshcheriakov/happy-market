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
	// - Прописать тесты для нашего приложения, какие считаете нужными

	public static void main(String[] args) {
		SpringApplication.run(HappyMarketApplication.class, args);
	}
}
