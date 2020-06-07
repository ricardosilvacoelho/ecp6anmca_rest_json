package br.usjt.app_previsoes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.usjt.app_previsoes.model.DiaSemana;
import br.usjt.app_previsoes.model.Previsao;
import br.usjt.app_previsoes.repository.PrevisoesRepository;
import br.usjt.app_previsoes.repository.DiaSemanaRepository;

@Controller
public class PrevisoesController {
    @Autowired
    private PrevisoesRepository previsoesRepo;

    @Autowired
    private DiaSemanaRepository diaSemanaRepo;

    @GetMapping("/previsoes")
    public ModelAndView listarPrevisoes() {
        ModelAndView mv = new ModelAndView("previsoes");

        mv.addObject(new Previsao());

        List<Previsao> previsoes = previsoesRepo.findAll();
        mv.addObject("previsoes", previsoes);

        List<DiaSemana> diasDaSemana = diaSemanaRepo.findAll();
        mv.addObject("diasDaSemana", diasDaSemana);

        return mv;
    }

    @PostMapping("/previsoes")
    public String salvarPrevisao(Previsao previsao) {
        previsoesRepo.save(previsao);
        return "redirect:/previsoes";
    }
}
