package com.viacoreit.scs.admin.gw.service.impl;

import java.util.List;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.viacoreit.scs.admin.gw.dto.ClienteDTO;
import com.viacoreit.scs.admin.gw.entity.Cliente;
import com.viacoreit.scs.admin.gw.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;
	private final ModelMapper modelMapper;
	
	public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper) {
		this.clienteRepository = clienteRepository;
		this.modelMapper = modelMapper;
	}
	
	public List<Cliente> getClientes(Boolean active) {
	    List<Cliente> clientes = clienteRepository.findByCriteria(active);

	    return clientes;
	}
	
	public Cliente addCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
		
	}
	
	
	public Cliente updateCliente(Cliente clienteExistente, ClienteDTO clienteDto) {
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(clienteDto, clienteExistente);
		
		
		return clienteRepository.save(clienteExistente);
		
	}

	public Cliente deleteCliente(Cliente cliente) {
		cliente.setDeleted(true);
		
		return clienteRepository.save(cliente);
		
	}
}
