package br.usjt.app_previsoes.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.usjt.app_previsoes.model.Cidade;
import br.usjt.app_previsoes.repository.CidadeRepository;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/cidades")
public class CidadeResource {
	@Autowired
	private CidadeRepository cidadeRepo;

	@GetMapping("/lista")
	public List<Cidade> todasAsCidades() {
		return cidadeRepo.findAll();
	}

	@GetMapping("/{id}")
	public Cidade buscarPeloId (@PathVariable Long id) {
		return cidadeRepo.getOne(id);
	}
	
	@GetMapping("/firstletter/{letter}")
	public Cidade buscarPelaPrimeiraLetra (@PathVariable char letter) {
		return cidadeRepo.findByNomeStartsWithIgnoreCase(letter + "");
	}

	@GetMapping("/latitude/{latitude}/longitude/{longitude}")
	public Cidade buscarPelaPrimeiraLetra (@PathVariable String latitude, @PathVariable String longitude) {
		return cidadeRepo.findByLatitudeAndLongitude(latitude, longitude);
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Cidade> salvar (@RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade l = cidadeRepo.save(cidade);
		URI uri = ServletUriComponentsBuilder.
			fromCurrentServletMapping().path("/cidades/{id}").
			buildAndExpand(l.getId()).
			toUri()
		;

		return ResponseEntity.created(uri).body(l);
	}
}
