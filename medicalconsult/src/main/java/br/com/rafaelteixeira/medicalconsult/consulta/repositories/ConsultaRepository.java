package br.com.rafaelteixeira.medicalconsult.consulta.repositories;

import br.com.rafaelteixeira.medicalconsult.consulta.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository  extends JpaRepository <Consulta,Long> {
}
