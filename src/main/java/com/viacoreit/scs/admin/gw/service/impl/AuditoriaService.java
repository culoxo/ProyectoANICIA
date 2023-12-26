package com.viacoreit.scs.admin.gw.service.impl;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.viacoreit.scs.admin.gw.entity.Auditoria;
import com.viacoreit.scs.admin.gw.repository.AuditoriaRepository;

@Service
public class AuditoriaService {

	private final AuditoriaRepository auditoriaRespository;

	public AuditoriaService(AuditoriaRepository auditoriaRespository) {
		this.auditoriaRespository = auditoriaRespository;
	}

	public List <Auditoria> getAllAuditoria(String startDate, String endDate) throws ParseException{
		Date fechaInicial, fechaFinal;
		Timestamp tsStartDate = null, tsEndDate = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if(startDate!=null) {
			fechaInicial = (Date) dateFormat.parse(startDate);
			tsStartDate = new Timestamp(fechaInicial.getTime());
		}
		
		if(endDate!=null) {
			fechaFinal = (Date) dateFormat.parse(endDate);
			tsEndDate = new Timestamp(fechaFinal.getTime());
		}

		return this.auditoriaRespository.findByCriterios(tsStartDate, tsEndDate);

	}	
}