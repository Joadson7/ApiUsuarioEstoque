package br.com.estoque.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Operation(summary = "Cria um novo usuário no sistema")
	@PostMapping("criar")
	public void criar() {

	}

	@Operation(summary = "Autentica um usuário no sistema")
	@PostMapping("autenticar")
	public void autenticar() {

	}
}
