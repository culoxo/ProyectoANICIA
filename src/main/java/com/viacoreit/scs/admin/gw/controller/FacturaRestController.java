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
import com.viacoreit.scs.admin.gw.dto.FacturaDTO;
import com.viacoreit.scs.admin.gw.entity.Factura;
import com.viacoreit.scs.admin.gw.handler.ResourceNotFoundException;
import com.viacoreit.scs.admin.gw.repository.ClienteRepository;
import com.viacoreit.scs.admin.gw.repository.FacturaRepository;
import com.viacoreit.scs.admin.gw.service.impl.ClienteService;
import com.viacoreit.scs.admin.gw.service.impl.FacturaService;

@RestController
@RequestMapping(path = "${api}/factura")
public class FacturaRestController {

	private final FacturaService facturaService;
	private final FacturaRepository facturaRepository;
	private final ModelMapper modelMapper;

	public FacturaRestController(FacturaService facturaService, FacturaRepository facturaRepository, ModelMapper modelMapper) {
		this.facturaService = facturaService;
		this.facturaRepository = facturaRepository;
		this.modelMapper = modelMapper;
	}

	@GetMapping
	public ResponseEntity<List<FacturaDTO>> getFacturas(@RequestParam (value="estado", required = false) Boolean estado) {
		return new ResponseEntity<>(this.facturaService.getFacturas(estado).stream()
				.map(factura -> modelMapper.map(factura, FacturaDTO.class))
				.collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping(path = "/{facturaId}")
	public ResponseEntity<FacturaDTO> getFacturabyId(@PathVariable Long facturaId) {
		return new ResponseEntity<>(modelMapper.map(facturaRepository.findById(facturaId)
				.orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada")),FacturaDTO.class), HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FacturaDTO> addFactura(@RequestBody @Valid FacturaDTO facturaDto) {
		return new ResponseEntity<>(modelMapper.map(facturaService.addFactura(
						modelMapper.map(facturaDto, Factura.class)), FacturaDTO.class), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{facturaId}")
	public ResponseEntity<FacturaDTO> updateFactura(@PathVariable Long facturaId, @RequestBody FacturaDTO facturaDto) {
		return new ResponseEntity<>(modelMapper
				.map(facturaService.updateFactura(facturaRepository.findById(facturaId)
						.orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada")), facturaDto), FacturaDTO.class), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{facturaId}")
	public ResponseEntity<FacturaDTO> deleteCliente(@PathVariable Long facturaId) {
		return new ResponseEntity<>(modelMapper
				.map(facturaService.deleteFactura(facturaRepository.findById(facturaId)
						.orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada"))), FacturaDTO.class), HttpStatus.OK);
	}
	
}