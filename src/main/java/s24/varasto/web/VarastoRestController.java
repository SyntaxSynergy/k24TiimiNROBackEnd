package s24.varasto.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s24.varasto.domain.Tuote;
import s24.varasto.domain.TuoteRepository;

import s24.varasto.domain.Valmistaja;
import s24.varasto.domain.ValmistajaRepository;

@RestController
public class VarastoRestController {

    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private ValmistajaRepository valRepository;

    @GetMapping("/tuotteetrest")
    public @ResponseBody List<Tuote> tuotelistausRest() {
        return (List<Tuote>) tuoteRepository.findAll();
    }

    @GetMapping("/tuote/{id}")
    public @ResponseBody Tuote findTuoteRest(@PathVariable("id") Long tuoteId) {
        return tuoteRepository.findById(tuoteId).get();
    }

    @GetMapping("/valmistajatrest")
    public @ResponseBody List<Valmistaja> valmistajalistausRest() {
        return (List<Valmistaja>) valRepository.findAll();
    }

    @GetMapping("/valmistaja/{id}")
    public @ResponseBody Valmistaja findValmistajaRest(@PathVariable("id") Long valmistajaId) {
        return valRepository.findById(valmistajaId).get();
    }


}
