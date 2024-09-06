package br.com.rafaelteixeira.medicalconsult.usuario.repositories;

import br.com.rafaelteixeira.medicalconsult.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
