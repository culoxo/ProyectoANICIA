package com.viacoreit.scs.admin.gw.handler;

import lombok.Data;

@Data
/**
 * DTO para devolver el nombre del campo erróneo y la descripción del error
 */
public class FieldNameAndMessageErrorDto {
    
    private static final long serialVersionUID = -7480784249774433256L;
	private String field;
    private String error;

    public FieldNameAndMessageErrorDto(String field, String error) {
        this.field = field;
        this.error = error;
    }
}
