package com.viacoreit.scs.admin.gw.ws.rest.configuracion;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.apache.cxf.binding.soap.SoapBindingConstants;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.addressing.MAPAggregator;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud.USUARIOSPortType;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Configuration
public class WebClientConfiguration {
/**
    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientConfiguration.class);

    @Value("${ws_soap.autentica.url}")
    private String serviceAutenticaUrl;
    @Value("${truststore.file}")
    private String truststoreFile;
    @Value("${truststore.type}")
    private String truststoreType;
    @Value("${truststore.password}")
    private String truststorePassword;
    @Value("${ws_rest.scsconsultas}")
    private String BASE_URL_SCS_CONSULTAS;
    @Value("${ws_rest.scspruebas}")
    private String BASE_URL_SCS_PRUEBAS;
    @Value("${ws_rest.scsprimaria}")
    private String BASE_URL_SCS_PRIMARIA;
    @Value("${ws_rest.dgc}")
    private String BASE_URL_DGC;
    @Value("${ws_rest.vacucan}")
    private String BASE_URL_VACUCAN;
    @Value("${ws.wearables.api.base-url}")
    private String BASE_URL_WEREABLES;

    @Value("${ws_rest.timeout}")
    private int TIMEOUT;

    @Bean(name = "webClientScsConsultas")
    public WebClient webClientScsConsultasWithTimeout() {
        LOGGER.info("[WebClientConfiguration] webClientScsConsultasWithTimeout - URL: {}", BASE_URL_SCS_CONSULTAS);
        final TcpClient tcpClient = TcpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, TIMEOUT)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                });

        return WebClient.builder()
                .baseUrl(BASE_URL_SCS_CONSULTAS)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();
    }
*/
}