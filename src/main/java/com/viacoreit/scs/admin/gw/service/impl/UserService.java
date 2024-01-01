package com.viacoreit.scs.admin.gw.service.impl;

import java.util.List;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.viacoreit.scs.admin.gw.dto.UserDTO;
import com.viacoreit.scs.admin.gw.entity.User;
import com.viacoreit.scs.admin.gw.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	public UserService(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	public List<User> getUsers(Boolean active, String password, String username ) {
	    List<User> user = userRepository.findByCriteria(active, password, username);

	    return user;
	}
	
	public User addUser(User user) {
//		Date fechaActual = new Date(); 
//		cliente.setCreatedDate(fechaActual);
		
		return this.userRepository.save(user);
		
	}
	
	public User updateUser(User userExistente, UserDTO userDto) {
		//Date fechaActual = new Date(); 
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(userDto, userExistente);
		//clienteExistente.setLastModifiedDate(fechaActual);
		
		return userRepository.save(userExistente);
		
	}

	public User deleteUser(User user) {
		//Date fechaActual = new Date();
		user.setDeleted(true);
		//cliente.setLastModifiedDate(fechaActual);
		
		return userRepository.save(user);
		
	}
}
