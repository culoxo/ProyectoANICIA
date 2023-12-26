package com.viacoreit.scs.admin.gw.controller;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.viacoreit.scs.admin.gw.dto.AuditoriaDTO;
import com.viacoreit.scs.admin.gw.handler.ResourceNotFoundException;
import com.viacoreit.scs.admin.gw.repository.AuditoriaRepository;
import com.viacoreit.scs.admin.gw.service.impl.AuditoriaService;

@RestController
@RequestMapping(path = "${api}/auditoria")
public class AuditoriaRestController {

	private final AuditoriaRepository auditoriaRepository;
	private final AuditoriaService auditoriaService;
	private final ModelMapper modelMapper;

	public AuditoriaRestController(AuditoriaRepository auditoriaRepository, AuditoriaService auditoriaService,ModelMapper modelMapper) {
		this.auditoriaRepository = auditoriaRepository;
		this.auditoriaService = auditoriaService;
		this.modelMapper = modelMapper;
	}

	@GetMapping
	public ResponseEntity<List<AuditoriaDTO>> getAllAuditoria(@RequestParam(value = "from", required = false) String startDate, @RequestParam(value = "to", required = false) String endDate) throws ParseException {
		return new ResponseEntity<>(this.auditoriaService.getAllAuditoria(startDate, endDate).stream()
				.map(auditoria -> modelMapper.map(auditoria, AuditoriaDTO.class))
				.collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping(path = "/{auditoriaId}")
	public ResponseEntity<AuditoriaDTO> getAuditoriaById(@PathVariable Long auditoriaId) {
		return new ResponseEntity<>(modelMapper.map(auditoriaRepository.findById(auditoriaId)
				.orElseThrow(() -> new ResourceNotFoundException("Auditoria no encontrado")), AuditoriaDTO.class),
				HttpStatus.OK);
	}
}
