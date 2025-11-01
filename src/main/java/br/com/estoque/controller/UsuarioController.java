package br.com.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estoque.dtos.request.AutenticarUsuarioRequest;
import br.com.estoque.dtos.request.CriarUsuarioRequest;
import br.com.estoque.dtos.response.AutenticarUsuarioResponse;
import br.com.estoque.dtos.response.CriarUsuarioResponse;
import br.com.estoque.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired UsuarioService usuarioService;
	
	@Operation(summary = "Serviço de API para criar usuário.")
	

	@PostMapping("criar")
	public ResponseEntity<CriarUsuarioResponse> criar(@RequestBody CriarUsuarioRequest request) {
		var response = usuarioService.criarUsuario(request);
		return ResponseEntity.ok(response);

	}

	@Operation(summary = "Autentica um usuário no sistema")
	@PostMapping("autenticar")
	public ResponseEntity<AutenticarUsuarioResponse> autenticar(@RequestBody AutenticarUsuarioRequest requets)  {
		
		var response = usuarioService.autenticarUsuario(requets);
		
        return ResponseEntity.ok(response);

	}
}
