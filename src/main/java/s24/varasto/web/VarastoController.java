package s24.varasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import s24.varasto.domain.Tuote;
import s24.varasto.domain.TuoteRepository;
import s24.varasto.domain.Valmistaja;
import s24.varasto.domain.ValmistajaRepository;

@Controller
public class VarastoController {
    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private ValmistajaRepository vrepository;

     @RequestMapping(value="/login")
    public String login() {	
    return "login";
     }	

    @GetMapping("/tuotteet")
    public String tuotelistaus(Model model) {
        //localhost:8080/varasto <-- Linkki kyseiseen sivuun :D
        model.addAttribute("tuotteet", tuoteRepository.findAll());
        return "tuotteet";
    }

    @GetMapping("/uusituote") 
    @PreAuthorize("hasAuthority('ADMIN')")
    public String uusiTuote(Model model) {
        model.addAttribute("tuote", new Tuote());
        model.addAttribute("valmistajat", vrepository.findAll());
        //localhost:8080/uusituote

        return "uusituote";
    }

    @GetMapping("/uusivalmistaja")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String uusiValmistaja(Model model) {
        model.addAttribute("valmistaja", new Valmistaja());
        //localhost:8080/uusival

        return "uusivalmistaja";
    }

    @PostMapping("/saveval")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveValmistaja(Valmistaja valmistaja) {
        vrepository.save(valmistaja);

        return "redirect:tuotteet";
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String save(Tuote tuote) {
        tuoteRepository.save(tuote);

        return "redirect:tuotteet";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteTuote(@PathVariable("id") Long tuoteId, Model model) {
        tuoteRepository.deleteById(tuoteId);
        return "redirect:../tuotteet";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editTuote(@PathVariable("id") Long tuoteId, Model model) {
        model.addAttribute("tuote", tuoteRepository.findById(tuoteId));
        model.addAttribute("valmistajat", vrepository.findAll());

        return "muokkaatuote";
    }

    
}
