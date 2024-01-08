package com.viacoreit.scs.admin.gw.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.viacoreit.scs.admin.gw.dto.UserDTO;
import com.viacoreit.scs.admin.gw.entity.User;
import com.viacoreit.scs.admin.gw.repository.UserRepository;
import java.util.Collections;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	 @Autowired
    private PasswordEncoder passwordEncoder;


	public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public List<User> getUsers(Boolean active, String password, String username) {
		List<User> users;

    if (username == null || password == null) {
        // Si no se proporciona ni username ni password, devolver toda la lista de usuarios
        users = userRepository.findByCriteria(active, password, username);
    } else if (username != null && password != null) {
		
        users = userRepository.findByCriteria(active,null,  username);
		users = users.stream()
		.filter(user -> passwordEncoder.matches(password, user.getPassword()))
		.collect(Collectors.toList());
    } else {
        // En otros casos, devolver una lista vacía
        users = Collections.emptyList();
    }

    return users;
}
	
	public User addUser(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return this.userRepository.save(user);
	}
	
	public User updateUser(User userExistente, UserDTO userDto) {
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		String encodedPassword = passwordEncoder.encode(userDto.getPassword());
		userDto.setPassword(encodedPassword);
		modelMapper.map(userDto, userExistente);
		
		return userRepository.save(userExistente);
		
	}

	public User deleteUser(User user) {

		user.setDeleted(true);
		return userRepository.save(user);
	}
}
