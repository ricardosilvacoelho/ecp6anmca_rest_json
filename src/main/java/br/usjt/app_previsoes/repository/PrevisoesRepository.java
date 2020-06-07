package br.usjt.app_previsoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.app_previsoes.model.DiaSemana;
import br.usjt.app_previsoes.model.Previsao;
import br.usjt.app_previsoes.model.Usuario;

public interface PrevisoesRepository extends JpaRepository<Previsao, Long>
{
    public Usuario findOneByDiaSemana(DiaSemana diaSemana);
}
