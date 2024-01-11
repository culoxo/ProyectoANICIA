package com.viacoreit.scs.admin.gw.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.viacoreit.scs.admin.gw.dto.ClienteDTO;
import com.viacoreit.scs.admin.gw.entity.Cliente;
import com.viacoreit.scs.admin.gw.handler.ResourceNotFoundException;
import com.viacoreit.scs.admin.gw.repository.ClienteRepository;
import com.viacoreit.scs.admin.gw.service.impl.ClienteService;

@RestController
@RequestMapping(path = "${api}/clientes")
public class ClienteRestController {

	private final ClienteService clienteService;
	private final ClienteRepository clienteRepository;
	private final ModelMapper modelMapper;

	public ClienteRestController(ClienteService clienteService, ClienteRepository clienteRepository, ModelMapper modelMapper) {
		this.clienteService = clienteService;
		this.clienteRepository = clienteRepository;
		this.modelMapper = modelMapper;
	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getClientes(@RequestParam (value="active", required = false) Boolean active) {
		return new ResponseEntity<>(this.clienteService.getClientes(active).stream()
				.map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
				.collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping(path = "/{clienteId}")
	public ResponseEntity<ClienteDTO> getClientesbyId(@PathVariable Long clienteId) {
		return new ResponseEntity<>(modelMapper.map(clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado")),ClienteDTO.class), HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> addCliente(@RequestBody @Valid ClienteDTO clienteDto) {
		return new ResponseEntity<>(modelMapper.map(clienteService.addCliente(
						modelMapper.map(clienteDto, Cliente.class)), ClienteDTO.class), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{clienteId}")
	public ResponseEntity<ClienteDTO> updateCliente(
			@PathVariable Long clienteId,
			@RequestBody ClienteDTO clienteDto) {
		// Puedes obtener el servicioId desde el clienteDto si es necesario
	
		return new ResponseEntity<>(modelMapper
				.map(clienteService.updateCliente(clienteId, clienteDto), ClienteDTO.class), HttpStatus.OK);
	}
	

	@DeleteMapping(path = "/{clienteId}")
	public ResponseEntity<ClienteDTO> deleteCliente(@PathVariable Long clienteId) {
		return new ResponseEntity<>(modelMapper
				.map(clienteService.deleteCliente(clienteRepository.findById(clienteId)
						.orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"))), ClienteDTO.class), HttpStatus.OK);
	}
	@PostMapping("/{clienteId}/agregar-servicio/{servicioId}")
    public ResponseEntity<ClienteDTO> agregarServicioACliente(
            @PathVariable Long clienteId,
            @PathVariable Long servicioId) {

        Cliente cliente = clienteService.agregarServicioACliente(clienteId, servicioId);
        return new ResponseEntity<>(modelMapper.map(cliente, ClienteDTO.class), HttpStatus.OK);
    }
	
}