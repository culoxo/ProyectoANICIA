package com.viacoreit.scs.admin.gw.service.impl;

import java.util.List;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.viacoreit.scs.admin.gw.dto.ClienteDTO;
import com.viacoreit.scs.admin.gw.entity.Cliente;
import com.viacoreit.scs.admin.gw.entity.Servicio;
import com.viacoreit.scs.admin.gw.handler.ResourceNotFoundException;
import com.viacoreit.scs.admin.gw.repository.ClienteRepository;
import com.viacoreit.scs.admin.gw.repository.ServicioRepository;

@Service
public class ClienteService {

	private ServicioRepository servicioRepository;
	private final ClienteRepository clienteRepository;
	private final ModelMapper modelMapper;
	
	public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper, ServicioRepository servicioRepository) {
		this.clienteRepository = clienteRepository;
		this.modelMapper = modelMapper;
		this.servicioRepository = servicioRepository;
	}
	
	public List<Cliente> getClientes(Boolean active) {
	    List<Cliente> clientes = clienteRepository.findByCriteria(active);
	    return clientes;
	}
	
	public Cliente addCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente updateCliente(Long clienteId, ClienteDTO clienteDto) {
		// Imprimir información sobre los datos recibidos
		System.out.println("Cliente ID recibido: " + clienteId);
		System.out.println("Cliente DTO recibido: " + clienteDto.toString());
	
		Cliente clienteExistente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + clienteId));
	
		// Actualizar los campos del cliente con la información proporcionada
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(clienteDto, clienteExistente);
	
		// Si se proporciona la lista de servicios, actualizarla
		if (clienteDto.getServicios() != null) {
			// Limpiar la lista actual de servicios del cliente
			clienteExistente.getServicios().clear();
	
			// Obtener los servicios proporcionados en el DTO y agregarlos al cliente
			for (Servicio servicioDto : clienteDto.getServicios()) {
				if (servicioDto.getServicioId() != null) {
					Servicio servicioExistente = servicioRepository.findById(servicioDto.getServicioId())
							.orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado con ID: " + servicioDto.getServicioId()));
	
					// Imprimir información sobre los servicios recibidos
					System.out.println("Servicio ID recibido: " + servicioDto.getServicioId());
					System.out.println("Servicio DTO recibido: " + servicioDto.toString());
	
					// Agregar el servicio existente al cliente
					clienteExistente.getServicios().add(servicioExistente);
				} else {
					// Manejar el caso cuando el ID del servicio es nulo (puedes lanzar una excepción o simplemente ignorarlo)
					throw new IllegalArgumentException("El ID del servicio no puede ser nulo para asociar servicios existentes.");
				}
			}
		}
	
		// Guardar el cliente actualizado en la base de datos
		Cliente clienteActualizado = clienteRepository.save(clienteExistente);
	
		// Imprimir información sobre el cliente actualizado
		System.out.println("Cliente actualizado: " + clienteActualizado.toString());
	
		return clienteActualizado;
	}
	
	
	

	public Cliente deleteCliente(Cliente cliente) {
		cliente.setDeleted(true);
		return clienteRepository.save(cliente);
	}
}
