package com.primeiroprojeto.userdept.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primeiroprojeto.userdept.entities.User;
import com.primeiroprojeto.userdept.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> findAll() {
		return userService.listarTodos();
	}

	@GetMapping(value = "/buscarUsuario/{id}")
	public User findById(@PathVariable Long id) {
		User result = userService.buscarPorId(id).get();
		return result;
	}

	@PostMapping
	public User insert(@RequestBody User user) {
		return userService.salvar(user);
	}
	
	@DeleteMapping(path = "/{id}/delete")
	public String deletarUsuario(@PathVariable Long id) {
		return userService.buscarPorId(id).map( entity -> {
			userService.deletar(entity);
			return "O usuário de id "+entity.getId() + " e de nome " + entity.getName() + " foi deletado com sucesso!";
		}).orElseGet(() -> new String("Não foi possível deletar. Verifique o id e novamente"));
	}

}
