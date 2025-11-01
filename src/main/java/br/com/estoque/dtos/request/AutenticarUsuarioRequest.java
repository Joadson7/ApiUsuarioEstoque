package br.com.estoque.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AutenticarUsuarioRequest {

	@Size(min = 8, message = "O nome de usuário deve ter no mínimo 8 caracteres.")
	@NotEmpty(message = "Por favor, informe a senha de acesso.")
	private String senha;
	
	@Email(message = "Por favor, insira um email válido.")
	@NotEmpty(message = "Por favor, informe o email de acesso.")
	private String email;
}

