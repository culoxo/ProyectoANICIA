package com.viacoreit.scs.admin.gw.dto;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ConfigurationProperties(prefix = "consumers")
@ToString
@Setter
@Getter
public class ConsumersDto {

    private List<ConsumerDto> consumersList = new ArrayList<>();

}