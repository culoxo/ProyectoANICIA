
package com.viacoreit.scs.admin.gw.autentica.implementacion;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.viacoreit.scs.admin.gw.dto.Auth;
import com.viacoreit.scs.admin.gw.entity.User;
import com.viacoreit.scs.admin.gw.entity.UserRole;
import com.viacoreit.scs.admin.gw.handler.ResourceNotFoundException;
import com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud.Credenciales;
import com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud.Datos;
import com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud.TEConecta;
import com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud.TSConecta;
import com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud.USUARIOSPortType;
import com.viacoreit.scs.admin.gw.repository.UserRepository;
import com.viacoreit.scs.admin.gw.repository.UserRoleRepository;
import com.viacoreit.scs.admin.gw.service.autentica.AutenticaService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Profile("!dev")
@Service
public class AutenticaSCSService implements AutenticaService {
/**
     //   private static final Logger logger = LoggerFactory.getLogger(AutenticaSCSService.class);

        private final static int ACCEPTED = 0;

        @Value("${ws_soap.autentica.application}")
        private String AUTENTICA_APPLICATION;
        @Value("${jwt.secret}")
        private String JWT_SECRET;
        @Value("${jwt.expiration}")
        private String EXPIRATION;

        @Qualifier("autenticaSCS")
        private USUARIOSPortType uSUARIOSPortType;

        private final UserRepository userRepository;
        private final UserRoleRepository userRoleRepository;

        public AutenticaSCSService(
                        USUARIOSPortType uSUARIOSPortType,
                        UserRepository userRepository,
                        UserRoleRepository userRoleRepository) {
                this.uSUARIOSPortType = uSUARIOSPortType;
                this.userRepository = userRepository;
                this.userRoleRepository = userRoleRepository;
        }

		@Override
		public Optional<Auth> autenticaUser(String username, String password) {
			// TODO Esbozo de método generado automáticamente
			return Optional.empty();
		}

        
         * Método de autenticación de usuarios
         * 
         * @param username String correspondiente al nombre de usuario
         * @param password String correspondiente a la contraseña
         * @param labCheck Boolean que será TRUE si el login se hace desde un
         *                 laboratorio, y FALSE en caso contrario
         * 
         * @return Instancia de {@link AuthToken} correspondiente al token que
         *         identifica al usuario si las credenciales son correctas. Si no,
         *         excepción
         */
       
        
        /**public Optional<Auth> autenticaUser(String username, String password) {
                logger.info("[AutenticaSCSService] - autenticaUser");
                Optional<Auth> result = Optional.empty();

                // Optional<User> user = userRepository.findByUsernameEnabled(username);
                Optional<User> user = userRepository.findByUsernameOrNifEnabled(username);
                if (user.isPresent()) {
                        Credenciales cre = new Credenciales();
                        cre.setAplicacion(AUTENTICA_APPLICATION);
                        cre.setLoginConexion(username);
                        cre.setPassConexion(password);

                        TEConecta peticion = new TEConecta();
                        peticion.setCredenciales(cre);
                        TSConecta tsConecta = new TSConecta();

                        tsConecta = uSUARIOSPortType.conectar(peticion);
                        logger.info("[AutenticaSCSService] - autenticaUser. tsConecta.getEstado().getAcepta() {}",
                                        tsConecta.getEstado().getAcepta());
                        logger.info("[AutenticaSCSService] - autenticaUser. tsConecta.getEstado().getMotivo() {}",
                                        tsConecta.getEstado().getMotivo());
                        logger.info("[AutenticaSCSService] - autenticaUser. tsConecta.getDatos().getNIF() {}",
                                        tsConecta.getDatos().getNIF());
                        logger.info("[AutenticaSCSService] - autenticaUser. tsConecta.getDatos().getLogin() {}",
                                        tsConecta.getDatos().getLogin());

                        if (ACCEPTED == tsConecta.getEstado().getAcepta()) {
                                logger.info("[AutenticaSCSService] - autenticaUser. tsConecta.getEstado().getAcepta() == 0");
                                // TODO revisar si el usuario tiene acceso a ambos módulos, preguntarle
                                // el token de acceso será para el módulo que seleccione si quiere cambiar tiene
                                // que salir y volver a entrar

                                result = this.generateToken(tsConecta.getDatos());
                        }
                }

                return result;
        }

        /**
         * Genera el token a partir de la información contenida en la instancia de
         * {@link Datos} pasada por parámetro
         * 
         * @param tsConectaDatos Instancia de {@link Datos} que contiene la información
         *                       del usuario
         * 
         * @return Instancia de {@link Auth} con el token generado
         *
        private Optional<Auth> generateToken(Datos tsConectaDatos) {
                User user = userRepository.findByDni(tsConectaDatos.getNIF().toUpperCase());
                return user != null ? Optional.of(this.generateJWTToken(tsConectaDatos, user))
                                : Optional.empty();
        }

        /**
         * Genera un token de autenticación para la instancia de {@link Datos} pasada
         * por parámetro
         * 
         * @param datosUsuario Instancia de {@link Datos}
         * 
         * @return Instancia de {@link Auth} con el token generado
         *
        private Auth generateJWTToken(Datos datosUsuario, User user) {

                // List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                // .commaSeparatedStringToAuthorityList("ROLE_SCS");
                // TODO dime el rol de este tío en este módulo
                Optional<UserRole> userRole = Optional.empty();
                List<UserRole> userRoles = this.userRoleRepository.findUserRolesByUser(user.getId());
                for (UserRole item : userRoles) {
                        userRole = Optional.of(item);
                }
                if (userRole.isPresent()) {
                        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                                        .commaSeparatedStringToAuthorityList(userRole.get().getRole().getCode());
                        // TODO llamada al repositorio

                        String token = Jwts.builder().setId("authJWT").setSubject(datosUsuario.getNIF())
                                        .claim("authorities",
                                                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
                                                                        .collect(Collectors.toList()))
                                        .claim("userData",
                                                        String.join(" ", datosUsuario.getNombre(),
                                                                        datosUsuario.getApellido1(),
                                                                        (StringUtils.isEmpty(
                                                                                        datosUsuario.getApellido2())
                                                                                                        ? ""
                                                                                                        : datosUsuario.getApellido2())))
                                        .claim("userDni", datosUsuario.getNIF())
                                        .claim("userProfessional", "SCS")
                                        .setIssuedAt(new Date(System.currentTimeMillis()))
                                        .setExpiration(new Date(
                                                        System.currentTimeMillis() + Integer.valueOf(EXPIRATION)))
                                        .signWith(SignatureAlgorithm.HS512, JWT_SECRET.getBytes()).compact();


                        return new Auth(token);
                } else {
                        throw new ResourceNotFoundException("Patient file not found");
                }
        }
*/
}
