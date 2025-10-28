package br.com.estoque.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estoque.entities.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, UUID> {

}
