package com.semnome.lojajogos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.semnome.lojajogos.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
