package com.primeiroprojeto.userdept.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.primeiroprojeto.userdept.entities.User;
import com.primeiroprojeto.userdept.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User salvar(User user) {
		return userRepository.save(user);
	}

	public List<User> listarTodos() {
		return userRepository.findAll();
	}

	public Optional<User> buscarPorId(Long id) {
		return userRepository.findById(id);
	}

	public void deletar(User user) {
		userRepository.delete(user);
	}
}
