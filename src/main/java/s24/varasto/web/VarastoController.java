package s24.varasto.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import s24.varasto.domain.Koko;
import s24.varasto.domain.Tuote;
import s24.varasto.domain.TuoteRepository;
import s24.varasto.domain.TuotetyyppiRepository;
import s24.varasto.domain.Valmistaja;
import s24.varasto.domain.ValmistajaRepository;

@Controller
public class VarastoController {
    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private ValmistajaRepository vrepository;
    @Autowired
    private TuotetyyppiRepository tuotetyyppiRepository;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/tuotteet")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String uusiTuote(Model model) {
        // localhost:8080/varasto <-- Linkki kyseiseen sivuun :D
        model.addAttribute("tuotteet", tuoteRepository.findAll());
        model.addAttribute("tuote", new Tuote());
        model.addAttribute("valmistajat", vrepository.findAll());
        model.addAttribute("tuotetyypit", tuotetyyppiRepository.findAll());
        List<Koko> koot = Arrays.asList(Koko.values());
        model.addAttribute("koot", koot);
        return "tuotteet";
    }

    @GetMapping("/valmistajat")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String uusiValmistaja(Model model) {
        model.addAttribute("valmistaja", new Valmistaja());
        model.addAttribute("valmistajat", vrepository.findAll());
        // localhost:8080/uusival

        return "valmistajat";
    }

    @GetMapping("/valmistajanTuotteet/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String valmistajanTuotteet(@PathVariable("id") Long valmistajaId, Model model) {
        Valmistaja valmistaja = vrepository.findById(valmistajaId)
            .orElseThrow(() -> new IllegalArgumentException("Valmistajaa ei löytynyt"));
    
        List<Tuote> tuotteet = tuoteRepository.findByValmistaja(valmistaja);
        model.addAttribute("valmistaja", valmistaja);
        model.addAttribute("tuotteet", tuotteet);
    
        return "valmistajanTuotteet";
    }

    @PostMapping("/saveval")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveValmistaja(@Valid @ModelAttribute Valmistaja valmistaja, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("valmistajat", vrepository.findAll());
            return "valmistajat";
        }
        vrepository.save(valmistaja);

        return "redirect:valmistajat";
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String save(@Valid @ModelAttribute Tuote tuote, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Jos lomake ei ole validi, lähetä takaisin lomakkeen kanssa virheiden ja tuotteiden tiedot
            model.addAttribute("tuote", tuote); // Lähetä tuote takaisin, jotta kentät säilyvät täytettyinä
            model.addAttribute("tuotteet", tuoteRepository.findAll()); // Lähetä myös kaikki tuotteet
            return "tuotteet"; // Palauta lomakesivu, jossa virheiden näyttäminen on määritelty
        }
        if ("LELU".equals(tuote.getTyyppi().getTyyppiNimi())) {
            tuote.setKoko(null); // Lelulle ei tarvita kokoa
        }
        tuoteRepository.save(tuote);

        return "redirect:tuotteet";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteTuote(@PathVariable("id") Long tuoteId, Model model) {
        tuoteRepository.deleteById(tuoteId);
        return "redirect:../tuotteet";
    }

    @GetMapping("/deletevalmistaja/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteValmistaja(@PathVariable("id") Long valmistajaId, Model model) {
        vrepository.deleteById(valmistajaId);
        return "redirect:../valmistajat";
    }

    @GetMapping("/deleteEmptyvalmistajat")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteEmptyValmistajat() {
        List<Valmistaja> valmistajat = (List<Valmistaja>) vrepository.findAll();
        for (Valmistaja valmistaja : valmistajat) {
            if (valmistaja.getTuotteet() == null || valmistaja.getTuotteet().isEmpty()) {
                vrepository.delete(valmistaja);
            }
        }
        return "redirect:/valmistajat";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editTuote(@PathVariable("id") Long tuoteId, Model model) {
        List<Koko> koot = Arrays.asList(Koko.values());
        model.addAttribute("tuote", tuoteRepository.findById(tuoteId));
        model.addAttribute("valmistajat", vrepository.findAll());
        model.addAttribute("tuotetyypit", tuotetyyppiRepository.findAll());
        model.addAttribute("koot", koot);

        return "muokkaatuote";
    }

}