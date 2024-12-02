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
import s24.varasto.domain.Asiakas;
import s24.varasto.domain.AsiakasRepository;
import s24.varasto.domain.Tilaus;
import s24.varasto.domain.TilausRepository;
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
    @Autowired
    private AsiakasRepository arepository;
    @Autowired
    private TilausRepository trepository;



    @GetMapping("/")
    public String etusivu() {
        return "etusivu";
    }
    
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

    @GetMapping("/asiakkaat")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String asiakkaat(Model model) {
        model.addAttribute("asiakas", new Asiakas());
        model.addAttribute("asiakkaat", arepository.findAll());
        return "asiakkaat";
    }

    @PostMapping("/savea")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveAsiakas(@Valid @ModelAttribute Asiakas asiakas, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("asiakkaat", arepository.findAll());
            return "asiakkaat";
        }
        arepository.save(asiakas);

        return "redirect:asiakkaat";
    }

    @GetMapping("/tilaukset")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String tilaukset(Model model) {
        model.addAttribute("tilaus", new Tilaus());
        model.addAttribute("tilaukset", trepository.findAll());
        model.addAttribute("asiakkaat", arepository.findAll());
        model.addAttribute("tuotteet", tuoteRepository.findAll());
        return "tilaukset";
    }

    @PostMapping("/savet")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveTilaus(@Valid @ModelAttribute Tilaus tilaus, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tilaukset", trepository.findAll());
            model.addAttribute("asiakkaat", arepository.findAll());
            model.addAttribute("tuotteet", tuoteRepository.findAll());

            return "tilaukset";
        }
        trepository.save(tilaus);

        return "redirect:tilaukset";
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
        model.addAttribute("tuote", tuote); //lataa takas tyypit koot jne
        model.addAttribute("tuotteet", tuoteRepository.findAll()); 
        model.addAttribute("valmistajat", vrepository.findAll()); 
        model.addAttribute("tuotetyypit", tuotetyyppiRepository.findAll()); 
        model.addAttribute("koot", Arrays.asList(Koko.values())); 

        return "tuotteet"; 
    }
        if ("LELU".equals(tuote.getTyyppi().getTyyppiNimi())) {
            tuote.setKoko(null); // Lelulle ei tarvita kokoa
        }
        tuoteRepository.save(tuote);

        return "redirect:tuotteet";
    }

    @GetMapping("/deleteasiakas/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteAsiakas(@PathVariable("id") Long asiakasid, Model model) {
        arepository.deleteById(asiakasid);
        return "redirect:../asiakkaat";
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

    @GetMapping("/deletetilaus/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteTilaus(@PathVariable("id") Long tilausid, Model model) {
        trepository.deleteById(tilausid);
        return "redirect:../tilaukset";
    }

    @GetMapping("/edittilaus/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editTilaus(@PathVariable("id") Long tilausid, Model model) {
        model.addAttribute("tilaus", trepository.findById(tilausid));
        model.addAttribute("asiakkaat", arepository.findAll());
        model.addAttribute("tuotteet", tuoteRepository.findAll());
        return "muokkaatilaus";
    }

    @GetMapping("/editasiakas/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editAsiakas(@PathVariable("id") Long asiakasid, Model model) {
        model.addAttribute("asiakas", arepository.findById(asiakasid));
        return "muokkaaasiakas";
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