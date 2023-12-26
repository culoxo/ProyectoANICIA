package com.viacoreit.scs.admin.gw.service.impl;

import java.util.List;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.viacoreit.scs.admin.gw.dto.ServicioDTO;
import com.viacoreit.scs.admin.gw.entity.Servicio;
import com.viacoreit.scs.admin.gw.repository.ServicioRepository;

@Service
public class ServicioService {

	private final ServicioRepository servicioRepository;
	private final ModelMapper modelMapper;

	public ServicioService(ServicioRepository servicioRepository, ModelMapper modelMapper) {
		this.servicioRepository = servicioRepository;
		this.modelMapper = modelMapper;
	}

	public List<Servicio> showActive(Boolean active) {
		List<Servicio> servicios = servicioRepository.findByCriteria(active);

		return servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		return this.servicioRepository.save(servicio);
	}


	public Servicio updateServicio(Servicio servicioExiste, ServicioDTO servicioDto) {
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());//Sirve para que ignore los nulos y grabe solo lo que tiene contenido
		modelMapper.map(servicioDto, servicioExiste);
	

		return servicioRepository.save(servicioExiste);
	}

	public Servicio deleteServicio(Servicio servicioExiste) {
		servicioExiste.setDeleted(true);

		return servicioRepository.save(servicioExiste);
	}
}
