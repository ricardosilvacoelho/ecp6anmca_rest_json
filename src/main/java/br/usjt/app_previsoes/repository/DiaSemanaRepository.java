package br.usjt.app_previsoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.usjt.app_previsoes.model.DiaSemana;

public interface DiaSemanaRepository extends JpaRepository<DiaSemana, Long>
{
}
