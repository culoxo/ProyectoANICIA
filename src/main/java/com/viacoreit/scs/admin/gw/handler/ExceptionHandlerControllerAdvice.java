package com.viacoreit.scs.admin.gw.handler;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import com.viacoreit.scs.admin.gw.controller.AuthRestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthRestController.class);

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        @ResponseBody
        public ExceptionResponse validationException(final MethodArgumentNotValidException exception, final HttpServletRequest request) {
        	
        	String mensaje = exception.getMessage();          	
        	LOGGER.error(mensaje);

            ExceptionResponse error = new ExceptionResponse();
            error.setUrl(request.getRequestURI());
            error.setError(HttpStatus.BAD_REQUEST.toString());
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            
            List<FieldNameAndMessageErrorDto> fieldsWithError = exception.getBindingResult().getFieldErrors().stream()
    	            .map(err -> new FieldNameAndMessageErrorDto(err.getField(), err.getDefaultMessage()))
    	            .distinct()
    	            .collect(Collectors.toList());
            
            error.setErrors(fieldsWithError);
            
            return error;
                
        }
        
        @ExceptionHandler(MysqlDataTruncation.class)
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        @ResponseBody
        public ExceptionResponse dataTruncation(final MysqlDataTruncation exception, final HttpServletRequest request) {
        	
        	String mensaje = exception.getMessage();        	
        	LOGGER.error(mensaje);
        	
            ExceptionResponse error = new ExceptionResponse();
            error.setError("El valor que intenta insertar es demasiado largo (límite 150 caracteres)");
            error.setMessage(mensaje);
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            error.setUrl(request.getRequestURI());
            
            return error;
                
        }

//        @ExceptionHandler(CsvNotValidException.class)
//        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//        @ResponseBody
//        public ExceptionResponse validationException(final CsvNotValidException exception,
//                        final HttpServletRequest request) {
//                String mensaje = exception.getMessage();
//                String codigoError = "CSV-001";
//                int codigoEstado = HttpStatus.BAD_REQUEST.value();
//                String detalles = exception.getMessage();
//                ExceptionResponse error = new ExceptionResponse();
//                error.setError(mensaje);
//                error.setMessage(detalles);
//                error.setStatus(codigoEstado);
//                error.setUrl(request.getRequestURI());
//                return error;
//        }
        

        @ExceptionHandler(ResourceNotFoundException.class)
        @ResponseStatus(value = HttpStatus.NOT_FOUND)
        @ResponseBody
        public ExceptionResponse handleResourceNotFoundException(final ResourceNotFoundException exception,
                        final HttpServletRequest request) {
        	
            String mensaje = exception.getMessage();        	
        	LOGGER.error(mensaje);
        	
            ExceptionResponse error = new ExceptionResponse();
            error.setError(HttpStatus.NOT_FOUND.toString());
            error.setMessage(mensaje);
            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setUrl(request.getRequestURI());
            
            return error;
            
        }
}
