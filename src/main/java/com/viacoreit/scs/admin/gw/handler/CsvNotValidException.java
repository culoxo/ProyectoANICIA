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
public class CsvNotValidException extends Exception{

    private String message;

    public CsvNotValidException(String message){
        this.message = message;
    }
}
