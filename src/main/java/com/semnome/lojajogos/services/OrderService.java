package com.semnome.lojajogos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semnome.lojajogos.entities.Order;
import com.semnome.lojajogos.repositories.OrderRepository;
import com.semnome.lojajogos.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		
		//return obj.get();
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
