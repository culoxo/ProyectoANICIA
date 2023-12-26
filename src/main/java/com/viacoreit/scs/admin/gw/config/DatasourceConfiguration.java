package com.viacoreit.scs.admin.gw.config;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "scsGatewayEntityManagerFactory", transactionManagerRef = "scsGatewayTransactionManager", basePackages = {
		"com.viacoreit.scs.admin.gw.repository" })
public class DatasourceConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "scsgateway.datasource")
	public DataSource scsGatewayDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	PlatformTransactionManager scsGatewayTransactionManager(
			@Qualifier("scsGatewayEntityManagerFactory") LocalContainerEntityManagerFactoryBean scsGatewayEntityManagerFactory) {
		return new JpaTransactionManager(scsGatewayEntityManagerFactory.getObject());
	}

	@Bean
	LocalContainerEntityManagerFactoryBean scsGatewayEntityManagerFactory(
			@Qualifier("scsGatewayDataSource") DataSource scsGatewayDataSource, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(scsGatewayDataSource).packages("com.viacoreit.scs.admin.gw.entity").build();
	}
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	
}