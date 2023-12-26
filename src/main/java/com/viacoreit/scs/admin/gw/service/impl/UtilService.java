package com.viacoreit.scs.admin.gw.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.viacoreit.scs.admin.gw.dto.UserDTO;

@Service
public class UtilService {
/**
	private static final Logger logger = LoggerFactory.getLogger(UtilService.class);

	private UserService userService;

	public UtilService(UserService userService) {
		this.userService = userService;
	}

	public String getModuleUserLogged() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDto userDto = this.userService.findDtoByUsername(authentication.getName());
		return userDto.getModule();
	}

	public Boolean isClinical() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDto userDto = this.userService.findDtoByUsername(authentication.getName());
		return userDto.isClinical();
	}

	public Boolean isPhysicalEducator() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Boolean res = Boolean.FALSE;
		if (authentication != null
				&& authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_SP_EF"))) {
			res = Boolean.TRUE;
		}
		return res;
	}

	public Long getCurrentUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDto userDto = this.userService.findDtoByUsername(authentication.getName());
		return userDto.getId();
	}

	public String calculateDuration(Date startDate, Date endDate) {
		String result = null;

		// Si fecha de fin es null, se estable la duración desde de dia inicial hasta
		// fecha actual
		if (endDate == null) {
			endDate = new Date();
		}

		if (startDate != null && endDate != null && startDate.before(endDate)) {
			Long milisecondsByDay = 86400000L;
			Long dias = (Long) ((endDate.getTime() - startDate.getTime()) / milisecondsByDay);
			result = String.valueOf(dias);
		}

		return result;
	}

	public Date calculateDrawStartDate(Date startDate, Date minDate) {
		return startDate.compareTo(minDate) < 0 ? minDate : startDate;
	}

	public Date calculateDrawEndDate(Date endDate, Date maxDate) {
		return (endDate == null || endDate.compareTo(maxDate) > 0) ? maxDate : endDate;
	}

	public Date calculateRealStartDate(Date startDate, Date minDate) {
		if (startDate == null) {
			startDate = minDate;
		}

		return startDate;
	}

	public Date calculateRealEndDate(Date endDate, Date maxDate) {
		if (endDate == null) {
			// como no se sabe el fin del episodio, se establece la fecha como la maxima de
			// la actual y la que se esta visualizando
			Date currentDate = new Date();
			endDate = currentDate;
			if (currentDate.after(maxDate)) {
				endDate = maxDate;
			}
		}

		return endDate;
	}

	public void calculateMaxMinDate(Date minDate, Date maxDate) {

		if (maxDate == null) {
			maxDate = new Date();
		}

		if (minDate == null) {
			// si es null, se pone como mindate la maxdate menos 6 meses
			LocalDate maxDateLocalDate = maxDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			YearMonth ymMaxDate = YearMonth.from(maxDateLocalDate);
			YearMonth ymMinDate = ymMaxDate.minusMonths(6);
			minDate = Date.from(ymMinDate.atDay(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
			;
		}

	}

	public Boolean eventInRange(Date eventStart, Date eventEnd, Date periodStart, Date periodEnd) {
		Boolean result = Boolean.FALSE;

		// logger.info("eventStart ---- " + eventStart.toString());
		// logger.info("eventEnd ---- " + eventEnd.toString());
		// logger.info("periodStart ---- " + periodStart.toString());
		// logger.info("periodEnd ---- " + periodEnd.toString());

		if (eventEnd == null) {
			try {
				eventEnd = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2100");
			} catch (ParseException e) {
				logger.info("Error en conversión fecha");
			}
		}

		if (
		// fecha final del evento dentro del rango del periodo
		eventEnd.compareTo(periodStart) == 0
				|| eventEnd.compareTo(periodEnd) == 0
				|| (eventEnd.compareTo(periodStart) > 0 && eventEnd.compareTo(periodEnd) < 0)
				// fecha inicio del evento dentro del rango del periodo
				|| eventStart.compareTo(periodStart) == 0
				|| eventStart.compareTo(periodEnd) == 0
				|| (eventStart.compareTo(periodStart) > 0 && eventStart.compareTo(periodEnd) < 0)
				// fecha de inicio del evento anterior a inicio de periodo y fecha de final de
				// evento posterior a ficha fin de evento
				|| (eventStart.compareTo(periodStart) < 0 && eventEnd.compareTo(periodEnd) > 0)) {
			result = Boolean.TRUE;
		}

		// logger.info("Evento dentro de periodo ---- " + result.toString());

		return result;

	}

	public void calculateMaxMinDateDoctorAppointment(Date minDate, Date maxDate) {
		// Los servicios web de citas de primaria al menos, no devuelven citas del
		// pasado, solo proximas citas
		// hospitales y pruebas de hospitales pendiente de verificar con datos

		if (minDate == null) {
			minDate = new Date();
		}

		if (maxDate == null) {
			// si es null, se pone como maxDate la minDate mas 6 meses, son las citas de los
			// proximos 6 meses
			LocalDate minDateLocalDate = minDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			YearMonth ymMinDate = YearMonth.from(minDateLocalDate);
			YearMonth ymMaxDate = ymMinDate.plusMonths(6);
			minDate = Date.from(ymMaxDate.atDay(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
			;
		}

	}

	public Boolean eventInRangeDoctorAppointment(Date eventDate, Date periodStart, Date periodEnd) {
		Boolean result = Boolean.FALSE;

		if (eventDate == null) {
			return result;
		}

		logger.info("eventStart ---- " + eventDate.toString());
		logger.info("periodStart ---- " + periodStart.toString());
		logger.info("periodEnd ---- " + periodEnd.toString());

		if (
		// fecha del evento dentro del rango del periodo
		eventDate.compareTo(periodStart) == 0
				|| eventDate.compareTo(periodEnd) == 0
				|| (eventDate.compareTo(periodStart) > 0 && eventDate.compareTo(periodEnd) < 0)) {
			result = Boolean.TRUE;
		}

		logger.info("Evento dentro de periodo ---- " + result.toString());

		return result;

	}

	public Date calculateDrawStartDateWithGap(Date startDate, Date minDate, Date maxDate) {
		long widthDrawDate = (maxDate.getTime() - minDate.getTime()) / (24 * 60 * 60 * 1000);
		long gapDays = Math.round(Math.ceil(widthDrawDate / 365)) * 2;

		LocalDateTime startDraw = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		startDraw = startDraw.minusDays(gapDays);
		return Date.from(startDraw.atZone(ZoneId.systemDefault()).toInstant());
	}

	public Date calculateDrawEndDateWithGap(Date endDate, Date minDate, Date maxDate) {
		long widthDrawDate = (maxDate.getTime() - minDate.getTime()) / (24 * 60 * 60 * 1000);
		long gapDays = Math.round(Math.ceil(widthDrawDate / 365)) * 2;

		LocalDateTime endDraw = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		endDraw = endDraw.plusDays(gapDays);
		return Date.from(endDraw.atZone(ZoneId.systemDefault()).toInstant());
	}

*/
}
