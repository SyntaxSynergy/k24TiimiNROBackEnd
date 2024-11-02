package s24.varasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import s24.varasto.domain.Tuote;
import s24.varasto.domain.TuoteRepository;
import s24.varasto.domain.ValmistajaRepository;

@Controller
public class VarastoController {
    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private ValmistajaRepository vrepository;

    @GetMapping("/tuotteet")
    public String tuotelistaus(Model model) {
        //localhost:8080/varasto <-- Linkki kyseiseen sivuun :D
        model.addAttribute("tuotteet", tuoteRepository.findAll());
        return "tuotteet";
    }

    @GetMapping("/uusituote")
    public String uusiTuote(Model model) {
        model.addAttribute("tuote", new Tuote());
        model.addAttribute("valmistajat", vrepository.findAll());
        //localhost:8080/uusituote

        return "uusituote";
    }

    @PostMapping("/save")
    public String save(Tuote tuote) {
        tuoteRepository.save(tuote);

        return "redirect:tuotteet";
    }

}
