package com.viacoreit.scs.admin.gw.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.viacoreit.scs.admin.gw.dto.UserDTO;
import com.viacoreit.scs.admin.gw.entity.User;
import com.viacoreit.scs.admin.gw.handler.ResourceNotFoundException;
import com.viacoreit.scs.admin.gw.repository.UserRepository;
import com.viacoreit.scs.admin.gw.service.impl.UserService;

@RestController
@RequestMapping(path = "${api}/usuarios")
public class UserRestController {

	private final UserService useService;
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	
	public UserRestController(UserService useService, UserRepository userRepository, ModelMapper modelMapper) {
		this.useService = useService;
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers(
		@RequestParam(required = false, name = "active") Boolean active,
		@RequestParam(required = false, name = "PASSWORD") String password,
		@RequestParam(required = false, name = "USERNAME") String username) {
		return new ResponseEntity<>(this.useService.getUsers(active, password, username).stream()
				.map(user -> modelMapper.map(user, UserDTO.class))
				.collect(Collectors.toList()), HttpStatus.OK);
	}

	@GetMapping(path = "/{userId}")
	public ResponseEntity<UserDTO> getUserbyId(@PathVariable Long userId) {
		return new ResponseEntity<>(modelMapper.map(userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado")),UserDTO.class), HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> addUser(@RequestBody @Valid UserDTO userDto) {
		return new ResponseEntity<>(modelMapper.map(useService.addUser(
						modelMapper.map(userDto, User.class)), UserDTO.class), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{userId}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDto) {
		return new ResponseEntity<>(modelMapper
				.map(useService.updateUser(userRepository.findById(userId)
						.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado")), userDto), UserDTO.class), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Long userId) {
		return new ResponseEntity<>(modelMapper
				.map(useService.deleteUser(userRepository.findById(userId)
						.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"))), UserDTO.class), HttpStatus.OK);
	}
	
}