package com.viacoreit.scs.admin.gw.handler;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {

    public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public List<FieldNameAndMessageErrorDto> getErrors() {
		return errors;
	}
	public void setErrors(List<FieldNameAndMessageErrorDto> errors) {
		this.errors = errors;
	}
	private String message;
    private String error;
    private String url;
    private long status;
    private List<FieldNameAndMessageErrorDto> errors;
}
