package com.viacoreit.scs.admin.gw.service.impl;

import java.util.List;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.viacoreit.scs.admin.gw.dto.FacturaDTO;
import com.viacoreit.scs.admin.gw.entity.Factura;
import com.viacoreit.scs.admin.gw.repository.FacturaRepository;

@Service
public class FacturaService {

	private final FacturaRepository facturaRepository;
	private final ModelMapper modelMapper;
	
	public FacturaService(FacturaRepository facturaRepository, ModelMapper modelMapper) {
		this.facturaRepository = facturaRepository;
		this.modelMapper = modelMapper;
	}
	
	public List<Factura> getFacturas(Boolean estado) {
	    List<Factura> facturas = facturaRepository.findByCriteria(estado);

	    return facturas;
	}
	
	public Factura addFactura(Factura factura) {
		return this.facturaRepository.save(factura);
		
	}
	
	
	public Factura updateFactura(Factura facturaExistente, FacturaDTO facturaDto) {
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(facturaDto, facturaExistente);
		
		
		return facturaRepository.save(facturaExistente);
		
	}

	public Factura deleteFactura(Factura factura) {
		factura.setDeleted(true);
		
		return facturaRepository.save(factura);
		
	}
}
