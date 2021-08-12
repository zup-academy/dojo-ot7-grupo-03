package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.form.AeroportoForm;
import br.com.zup.edu.nossositedeviagens.modelo.Aeroporto;
import br.com.zup.edu.nossositedeviagens.repositorio.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.repositorio.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    private AeroportoRepository repository;
    private PaisRepository paisRepository;

    public AeroportoController(AeroportoRepository repository, PaisRepository paisRepository) {
        this.repository = repository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarAreoporto (@RequestBody @Valid AeroportoForm form ) {

        Aeroporto aeroporto = form.toModel(paisRepository);
        repository.save(aeroporto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aeroporto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
