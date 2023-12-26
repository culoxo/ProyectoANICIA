
package com.viacoreit.scs.admin.gw.service.autentica.mock;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
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
import com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud.Datos;
import com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud.USUARIOSPortType;
import com.viacoreit.scs.admin.gw.repository.UserRepository;
import com.viacoreit.scs.admin.gw.repository.UserRoleRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Profile("dev")
@Service
public class AutenticaSCSMockService
        implements com.viacoreit.scs.admin.gw.service.autentica.AutenticaService {

    @Value("${ws_soap.autentica.application}")
    private String AUTENTICA_APPLICATION;
    @Value("${jwt.secret}")
    private String JWT_SECRET;
    @Value("${jwt.expiration}")
    private String EXPIRATION;

    @Qualifier("autenticaSCS")
    private USUARIOSPortType uSUARIOSPortType;

    private UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public AutenticaSCSMockService(USUARIOSPortType uSUARIOSPortType, UserRepository userRepository,
    UserRoleRepository userRoleRepository) {
        this.uSUARIOSPortType = uSUARIOSPortType;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }
/**
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
     *         identifica al usuario si las credenciales
     *         son correctas. Si no, excepción
     *
    public Optional<Auth> autenticaUser(String username, String password) {
        Optional<Auth> result = Optional.empty();

        Optional<User> user = userRepository.findByUsernameEnabled(username);
        if (user.isPresent()) {
            Datos mockUser = new Datos();
            mockUser.setApellido1("Ap1");
            mockUser.setApellido2("Ap2");
            mockUser.setNombre("Nombre");
            mockUser.setNIF(user.get().getUsername());
            result = Optional.of(this.generateJWTToken(mockUser, user.get()));

        }

        return result;
    }

    /**
     * Genera el token de autenticación para los datos pasados por parámetro
     * 
     * @param datosUsuario Instancia de {@link Datos} con la información del usuario
     * 
     * @return Instancia de {@link Auth} con el token generado
     *
    private Auth generateJWTToken(Datos datosUsuario, User user) {

        // List<GrantedAuthority> grantedAuthorities = AuthorityUtils
        // .commaSeparatedStringToAuthorityList("ROLE_SCS");
        // Optional<UserRole> userRole = this.userRoleRepository.findByUserAndModule(user.getId(), module);
        Optional<UserRole> userRole = Optional.empty();
        List<UserRole> userRoles = this.userRoleRepository.findUserRolesByUser(user.getId());
        for(UserRole item: userRoles) {
            userRole = Optional.of(item);

        }

        //Optional<UserRole> userRole = this.userRoleRepository.findByUser(user.getId());
        if (userRole.isPresent()) {
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                    .commaSeparatedStringToAuthorityList(userRole.get().getRole().getCode());

            String token = Jwts.builder().setId("authJWT").setSubject(datosUsuario.getNIF())
                    .claim("authorities",
                            grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
                                    .collect(Collectors.toList()))
                    .claim("userData",
                            String.join(" ", datosUsuario.getNombre(), datosUsuario.getApellido1(),
                                    (StringUtils.isEmpty(datosUsuario.getApellido2()) ? ""
                                            : datosUsuario.getApellido2())))
                    .claim("userDni", datosUsuario.getNIF())
                    .claim("userProfessional", "SCS")
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + Integer.valueOf(EXPIRATION)))
                    .signWith(SignatureAlgorithm.HS512, JWT_SECRET.getBytes()).compact();


            return new Auth(token);
        } else {
            throw new ResourceNotFoundException("Patient file not found");
        }
    }
*/
}
