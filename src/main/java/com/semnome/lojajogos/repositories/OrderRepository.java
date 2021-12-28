package com.semnome.lojajogos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.semnome.lojajogos.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
