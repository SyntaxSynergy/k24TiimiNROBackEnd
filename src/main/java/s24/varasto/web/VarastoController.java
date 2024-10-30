package s24.varasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import s24.varasto.domain.TuoteRepository;

@Controller
public class VarastoController {
    @Autowired
    private TuoteRepository tuoteRepository;

    @GetMapping("/tuotteet")
    public String tuotelistaus(Model model) {
        //localhost:8080/varasto <-- Linkki kyseiseen sivuun :D
        model.addAttribute("tuotteet", tuoteRepository.findAll());
        return "tuotteet";
    }

}
