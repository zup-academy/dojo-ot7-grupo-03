package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.form.CompanhiaForm;
import br.com.zup.edu.nossositedeviagens.modelo.Companhia;
import br.com.zup.edu.nossositedeviagens.repositorio.CompanhiaRepository;
import br.com.zup.edu.nossositedeviagens.repositorio.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {
    @Autowired
    CompanhiaRepository companhiaRepository;
    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CompanhiaForm companhiaForm, UriComponentsBuilder uriComponentsBuilder){
        Optional<Companhia> possivelCompanhia = companhiaForm.converterForm(paisRepository);

        if(possivelCompanhia.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        URI uri = uriComponentsBuilder.path("/companhias/{id}").buildAndExpand(possivelCompanhia.get().getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
