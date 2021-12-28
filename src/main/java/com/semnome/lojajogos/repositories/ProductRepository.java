package com.semnome.lojajogos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.semnome.lojajogos.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
