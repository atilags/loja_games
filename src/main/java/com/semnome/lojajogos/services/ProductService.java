package com.semnome.lojajogos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semnome.lojajogos.entities.Product;
import com.semnome.lojajogos.repositories.ProductRepository;
import com.semnome.lojajogos.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		
		//return obj.get();
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
