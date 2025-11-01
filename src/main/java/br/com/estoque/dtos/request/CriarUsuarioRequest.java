package br.com.estoque.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequest {

	@NotEmpty(message = "Por favor, informe o nome de usuário.")
	@Size(min = 8, max = 150, message = "O nome de usuário deve ter de 8 a 150 caracteres.")
	private String nome;
	
	@Email(message = "Por favor, insira um email válido.")
	@NotEmpty(message = "Por favor, informe o email de acesso.")
	private String email;
	
	
	@Size(min = 8, message = " Por favor, informe a senha do usuário.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
	message = "A senha deve ter, pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial.")
	private String senha;
}
