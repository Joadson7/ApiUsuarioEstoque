package br.com.estoque.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estoque.components.JwtTokenComponent;
import br.com.estoque.components.SHA256Component;
import br.com.estoque.dtos.request.AutenticarUsuarioRequest;
import br.com.estoque.dtos.request.CriarUsuarioRequest;
import br.com.estoque.dtos.response.AutenticarUsuarioResponse;
import br.com.estoque.dtos.response.CriarUsuarioResponse;
import br.com.estoque.entities.Usuario;
import br.com.estoque.repositories.PerfilRepository;
import br.com.estoque.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired UsuarioRepository usuarioRepository;
	@Autowired PerfilRepository perfilRepository;
	@Autowired SHA256Component sha256Comonent;
	@Autowired JwtTokenComponent jwtTokenComponent;
	public CriarUsuarioResponse criarUsuario(CriarUsuarioRequest request) {
		
		if (usuarioRepository.findByEmail(request.getEmail())
				!= null) {
			throw new IllegalArgumentException("Email informado já está cadastrado, tente outro.");
		}
		
		var usuario = new Usuario();
		
		usuario.setNome(request.getNome());
		usuario.setEmail(request.getEmail());
		usuario.setSenha(sha256Comonent.encrypt(request.getSenha()));
		usuario.setPerfil(perfilRepository.findByNome("Operador"));
		
		usuarioRepository.save(usuario);
		
		var response = new CriarUsuarioResponse();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setDataCriacao(Instant.now());
		response.setPerfil(usuario.getPerfil().getNome());
		
		return response; // Retornar a resposta apropriada
	}

	public AutenticarUsuarioResponse autenticarUsuario(AutenticarUsuarioRequest request) {
		
		var usuario = usuarioRepository.findByEmailAndSenha(request.getEmail(),
				sha256Comonent.encrypt(request.getSenha()));
		
		if (usuario == null) {
			throw new IllegalArgumentException
			("Acesso negado. Usuário não encontrado.");
		}
		
		var response = new AutenticarUsuarioResponse();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setPerfil(usuario.getPerfil().getNome());
		response.setToken(jwtTokenComponent.getToken(usuario));
		
		return response;
		
	}
}
