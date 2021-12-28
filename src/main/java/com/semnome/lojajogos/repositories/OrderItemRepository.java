package com.semnome.lojajogos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.semnome.lojajogos.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
