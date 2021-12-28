package com.semnome.lojajogos.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.semnome.lojajogos.entities.Client;
import com.semnome.lojajogos.repositories.ClientRepository;
import com.semnome.lojajogos.services.exceptions.DatabaseException;
import com.semnome.lojajogos.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		
		//return obj.get();
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Client insert(Client client) {
		return repository.save(client);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Client update(Long id, Client client) {
		try {
			Client clientAtt = repository.getById(id);
			clientAtt.setName(client.getName());
			clientAtt.setEmail(client.getEmail());
			
			return repository.save(clientAtt);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
