package com.semnome.lojajogos.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.semnome.lojajogos.entities.Category;
import com.semnome.lojajogos.entities.Client;
import com.semnome.lojajogos.entities.Order;
import com.semnome.lojajogos.entities.OrderItem;
import com.semnome.lojajogos.entities.Payment;
import com.semnome.lojajogos.entities.Product;
import com.semnome.lojajogos.entities.Enum.OrderStatus;
import com.semnome.lojajogos.repositories.CategoryRepository;
import com.semnome.lojajogos.repositories.ClientRepository;
import com.semnome.lojajogos.repositories.OrderItemRepository;
import com.semnome.lojajogos.repositories.OrderRepository;
import com.semnome.lojajogos.repositories.ProductRepository;

@Configuration
@Profile("testando")
public class ConfigBase implements CommandLineRunner{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderReposiroty;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category("Jogos de Ação");
		Category cat2 = new Category("Jogos de RPG");
		Category cat3 = new Category("Jogos de Simulação");
		Category cat4 = new Category("Eletronico");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
		Product prod1 = new Product("Final Fantasy XIV Online", 105.99, "Faça parte de um FINAL FANTASY épico e sempre renovado, aventurando-se e explorando ao lado de amigos do mundo inteiro.");
		Product prod2 = new Product("Nioh 2 – The Complete Edition", 249.50, "Desfruta da emoção de chacinar em batalha as temíveis hordas de yokai neste violento RPG de ação de dificuldade extrema.");
		Product prod3 = new Product("Stardew Valley", 24.99, "Você herdou a antiga fazenda do seu avô, em Stardew Valley. Com ferramentas de segunda-mão e algumas moedas, você parte para dar início a sua nova vida. Será que você vai aprender a viver da terra, a transformar esse matagal em um próspero lar?");
		Product prod4 = new Product("Computador Gamer", 4689.98, "Computador gamer completo e pronto para utilização. SSD 1GB, 32 GB RAM, GTX 1060.");
		Product prod5 = new Product("Controle Sem Fio Xbox + Cabo USB", 479.00, "Controle Xbox Series X/S + Cabo Windows - Black - Microsoft 1V8-00013");
		
		prod1.getCategories().add(cat2);
		prod2.getCategories().add(cat1);
		prod2.getCategories().add(cat2);
		prod3.getCategories().add(cat2);
		prod3.getCategories().add(cat3);
		prod4.getCategories().add(cat4);
		prod5.getCategories().add(cat4);
		
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
		
		Client c1 = new Client("Jessica Blue", 13228169723l, "jessica@gmail.com", "123456abcd");
		Client c2 = new Client("Yago Green", 15987569856l, "yago@gmail.com", "123456abcd");
		Client c3 = new Client("Google Red", 15987568952l, "google@gmail.com", "123456abcd");
		Client c4 = new Client("Yahoo Purple", 36851768512l, "yahoo@gmail.com", "123456abcd");
		
		clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Order or1 = new Order(Instant.parse("2019-08-12T18:32:04Z"), OrderStatus.PAID, c2);
		Order or2 = new Order(Instant.parse("2019-02-25T10:03:19Z"), OrderStatus.PAID, c1);
		Order or3 = new Order(Instant.parse("2019-05-02T16:33:08Z"), OrderStatus.CANCELED, c3);
		Order or4 = new Order(Instant.parse("2020-01-05T19:48:13Z"), OrderStatus.WAINTING_PAYMENT, c4);
		Order or5 = new Order(Instant.parse("2021-12-05T22:00:56Z"), OrderStatus.WAINTING_PAYMENT, c2);
		
		OrderItem ori1 = new OrderItem(or1, prod3, 1, prod3.getPrice());
		OrderItem ori2 = new OrderItem(or1, prod5, 2, prod5.getPrice());
		OrderItem ori3 = new OrderItem(or2, prod4, 1, prod4.getPrice());
		OrderItem ori4 = new OrderItem(or2, prod3, 1, prod3.getPrice());
		OrderItem ori5 = new OrderItem(or3, prod1, 1, prod3.getPrice());
		OrderItem ori6 = new OrderItem(or4, prod3, 1, prod3.getPrice());
		OrderItem ori7 = new OrderItem(or5, prod2, 1, prod3.getPrice());
		
		orderReposiroty.saveAll(Arrays.asList(or1, or2, or3, or4, or5));
		orderItemRepository.saveAll(Arrays.asList(ori1, ori2, ori3, ori4, ori5, ori6, ori7));
		
		Payment paid1 = new Payment(Instant.parse("2019-08-13T12:30:00Z"), or1);
		Payment paid2 = new Payment(Instant.parse("2019-03-01T09:44:13Z"), or2);
		
		or1.setPayment(paid1);
		or2.setPayment(paid2);
		
		orderReposiroty.saveAll(Arrays.asList(or1, or2));
		
	}

}
