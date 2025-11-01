package br.com.estoque.dtos.response;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class CriarUsuarioResponse {

	private UUID id;
	private String nome;
	private String email;
	private String perfil;
	private Instant dataCriacao;
}
