package br.usjt.app_previsoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.app_previsoes.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	Cidade findByNomeStartsWithIgnoreCase(String letter);

	Cidade findByLatitudeAndLongitude(String latitude, String longitude);
}
