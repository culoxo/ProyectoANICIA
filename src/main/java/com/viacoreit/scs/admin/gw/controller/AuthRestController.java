package com.viacoreit.scs.admin.gw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viacoreit.scs.admin.gw.dto.Auth;
import com.viacoreit.scs.admin.gw.dto.Credentials;
import com.viacoreit.scs.admin.gw.dto.UserDTO;
import com.viacoreit.scs.admin.gw.entity.User;
import com.viacoreit.scs.admin.gw.handler.UnauthorizedException;
import com.viacoreit.scs.admin.gw.service.autentica.AutenticaService;
import com.viacoreit.scs.admin.gw.service.impl.UserService;

@RestController
@RequestMapping(path = "${api}")
public class AuthRestController {
	/**
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthRestController.class);


  private final AutenticaService authService;
  private final UserService userService;

  public AuthRestController(AutenticaService authService, UserService userService) {
    this.authService = authService;
    this.userService = userService;
  }

  @PostMapping("/login")
  public Auth login(@RequestBody Credentials credentiale) {
    return authService.autenticaUser(credentiale.getUsername(), credentiale.getPassword())
        .orElseThrow(() -> new UnauthorizedException("Invalid Credentials"));
  }
/
  @GetMapping("/me")
  public UserDto me() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getName();
    
	LOGGER.info("[AuthRestController] - me " + currentPrincipalName);

    
    return this.userService.getMe(currentPrincipalName)
        .orElseThrow(() -> new UnauthorizedException("Invalid Credentials"));
  }
*/
}