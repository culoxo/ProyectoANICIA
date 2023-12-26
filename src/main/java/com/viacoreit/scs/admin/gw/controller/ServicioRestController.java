package com.viacoreit.scs.admin.gw.controller;

import java.util.List;
import java.util.stream.Collectors;
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
import com.viacoreit.scs.admin.gw.dto.ServicioDTO;
import com.viacoreit.scs.admin.gw.entity.Servicio;
import com.viacoreit.scs.admin.gw.handler.ResourceNotFoundException;
import com.viacoreit.scs.admin.gw.repository.ServicioRepository;
import com.viacoreit.scs.admin.gw.service.impl.ServicioService;

@RestController
@RequestMapping (path = "${api}/servicios")
public class ServicioRestController {

	private final ServicioService servicioService;
	private final ModelMapper modelMapper;
	private final ServicioRepository servicioRepository;

	public ServicioRestController(ServicioService servicioService, ModelMapper modelMapper, ServicioRepository servicioRepository) {
		this.servicioService = servicioService;
		this.modelMapper = modelMapper;
		this.servicioRepository = servicioRepository;
	}

	@GetMapping
	public ResponseEntity<List<ServicioDTO>> getClientes(@RequestParam (value="active", required = false) Boolean active) {
		return new ResponseEntity<>(this.servicioService.showActive(active).stream()
				.map(servicio -> modelMapper.map(servicio, ServicioDTO.class))
				.collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping (path = "/{servicioId}")
	public ResponseEntity<ServicioDTO> getServicioById(@PathVariable Long servicioId) {
		Servicio servicioExiste = this.servicioRepository.findById(servicioId)
				.orElseThrow(()-> new ResourceNotFoundException("Cliente no encontrado"));

		return new ResponseEntity <>(modelMapper.map(servicioExiste, ServicioDTO.class), HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServicioDTO> addServicio(@RequestBody ServicioDTO servicioDTO) {
		ServicioDTO newServicio = modelMapper
				.map(servicioService.addServicio(
						modelMapper.map(servicioDTO, Servicio.class)), ServicioDTO.class);

		return new ResponseEntity <>(newServicio, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{servicioId}")
	public ResponseEntity<ServicioDTO> updateServicio(@PathVariable Long servicioId, @RequestBody ServicioDTO servicioDTO) {
		Servicio servicioExiste = this.servicioRepository.findById(servicioId)
				.orElseThrow(()-> new ResourceNotFoundException("Cliente no encontrado"));

		ServicioDTO servicioActualizado = modelMapper
				.map(servicioService.updateServicio(servicioExiste, servicioDTO),ServicioDTO.class);

		return new ResponseEntity<>(servicioActualizado, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/{servicioId}")
	public ResponseEntity<ServicioDTO> deleteServicio(@PathVariable Long servicioId){
		Servicio servicioExiste = this.servicioRepository.findById(servicioId)
				.orElseThrow(()-> new ResourceNotFoundException("Cliente no encontrado"));

		return new ResponseEntity<>(modelMapper.map(servicioService.deleteServicio(servicioExiste), ServicioDTO.class), HttpStatus.OK);
	}
}
