package com.viacoreit.scs.admin.gw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/admin/*").permitAll()
                .antMatchers(HttpMethod.GET, "/*.html").permitAll()
                .antMatchers(HttpMethod.GET, "/**/*.html").permitAll()
                .antMatchers(HttpMethod.GET, "/manifest.json").permitAll()
                .antMatchers(HttpMethod.GET, "/**.js").permitAll()
                .antMatchers(HttpMethod.GET, "/css/*.css").permitAll()
                .antMatchers(HttpMethod.GET, "/img/*.png").permitAll()
                .antMatchers(HttpMethod.GET, "/img/*.svg").permitAll()
                .antMatchers(HttpMethod.GET, "/**.png").permitAll()
                .antMatchers(HttpMethod.GET, "/robots.txt").permitAll()
                .antMatchers(HttpMethod.GET, "/favicon.ico").permitAll()
                .antMatchers(HttpMethod.GET, "/static/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(HttpMethod.GET, "/files/*").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/login").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/clientes").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/clientes/*").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/clientes").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/v1/clientes/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/v1/clientes/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/servicios").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/servicios/*").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/servicios").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/v1/servicios/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/v1/servicios/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/auditoria").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/auditoria/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/usuarios").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/usuarios/*").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/usuarios").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/v1/usuarios/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/v1/usuarios/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/factura").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/factura/*").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/factura").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/v1/factura/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/v1/factura/*").permitAll()
                

                // Login citizen
                .antMatchers(HttpMethod.POST, "/api/v1/citizen/check-pin-pwa").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/citizen/questionnaire/*").permitAll()

                // Borrar
                .antMatchers(HttpMethod.POST, "/api/v1/covid19/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/scs-consulta/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/scs-primaria/citas").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/scs-historia-clinica/hcr").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/scs-historia-clinica/hcr").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/covid19/liscan-tests").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/covid19/liscan-tests").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/timeline/period").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/timeline/event-type/all").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/doctor-appointments/period").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/doctor-appointments/event-type/all").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/vaccine/all").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/patient-files-poll/sms-masive").permitAll()
                // Borrar

                .anyRequest().authenticated();

        // Custom JWT based security filter
        // http.addFilterBefore(jwtFilter(),
        // UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        http.headers().cacheControl().disable();
    }

}