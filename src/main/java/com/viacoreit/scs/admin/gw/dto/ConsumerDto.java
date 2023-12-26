package com.viacoreit.scs.admin.gw.dto;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@Setter
@Getter
public class ConsumerDto {

    private String app;
    private String key;
    private String pinSms;
    private String phoneAuthDenied;
    private String phoneAuthUndefined;
    private String maxSms24h;
    private String jwtExpiration;
    private String[] checkIn;

}