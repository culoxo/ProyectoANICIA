
package com.viacoreit.scs.admin.gw.ws.soap.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

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

import com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud.USUARIOSPortType;

@Configuration

public class WebServiceConfiguration {

	private static final Logger log = LoggerFactory.getLogger(WebServiceConfiguration.class.getName());

	/* url base scs */
	@Value("${ws_soap.historiaclinica.url}")
	private String serviceHistoriaClinicaUrl;

	/* data truststore */
	@Value("${truststore.alias}")
	private String truststoreAlias;
	@Value("${truststore.password}")
	private String truststorePassword;
	@Value("${truststore.file}")
	private String truststoreFile;
	@Value("${truststore.type}")
	private String truststoreType;
	@Value("${ws_soap.mentes.url}")
	private String serviceMentesUrl;

    @Value("${ws_soap.autentica.url}")
    private String serviceAutenticaUrl;

    @Bean(name = "autenticaSCS")
    public USUARIOSPortType getAutenticaSCS() {

        JaxWsProxyFactoryBean jaxWsProxyFactory = new JaxWsProxyFactoryBean();
        jaxWsProxyFactory.setServiceClass(USUARIOSPortType.class);
        jaxWsProxyFactory.setBindingId(SoapBindingConstants.SOAP11_BINDING_ID); // SOAP 1.1
        jaxWsProxyFactory.setAddress(serviceAutenticaUrl);

        USUARIOSPortType result = (USUARIOSPortType) jaxWsProxyFactory.create(USUARIOSPortType.class);
        configureSSLOnTheClient(result, truststoreFile, truststorePassword);
        return result;

    }

	// conduit

    /**
     * 
     * @param c
     * @param keyStorePath
     * @param keyStorePassword
     */
    private void configureSSLOnTheClient(Object c, String keyStorePath, String keyStorePassword) {

        Client client = ClientProxy.getClient(c);

        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

        File truststore = new File(keyStorePath);

        client.getOutInterceptors().add(new MAPAggregator());
        client.getOutInterceptors().add(new MAPCodec());

        try {
            TLSClientParameters tlsParams = new TLSClientParameters();
            tlsParams.setDisableCNCheck(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(truststore), keyStorePassword.toCharArray());

            TrustManagerFactory trustFactory = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(keyStore);

            TrustManager[] tm = trustFactory.getTrustManagers();

            tlsParams.setTrustManagers(tm);

            keyStore.load(new FileInputStream(truststore), keyStorePassword.toCharArray());

            KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyFactory.init(keyStore, keyStorePassword.toCharArray());

            KeyManager[] km = keyFactory.getKeyManagers();

            tlsParams.setKeyManagers(km);

            httpConduit.setTlsClientParameters(tlsParams);

            HTTPClientPolicy httpClient = httpConduit.getClient();
            // Solved chunking http header size
            httpClient.setAllowChunking(Boolean.FALSE);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

	}


	

	



}
