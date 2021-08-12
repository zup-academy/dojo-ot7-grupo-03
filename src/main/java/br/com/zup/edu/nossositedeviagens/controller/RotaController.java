package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.form.RotaForm;
import br.com.zup.edu.nossositedeviagens.modelo.Rota;
import br.com.zup.edu.nossositedeviagens.repositorio.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.repositorio.RotaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    private RotaRepository rotaRepository;
    private AeroportoRepository aeroportoRepository;

    public RotaController(RotaRepository rotaRepository, AeroportoRepository aeroportoRepository) {
        this.rotaRepository = rotaRepository;
        this.aeroportoRepository = aeroportoRepository;
    }

    public ResponseEntity<Void> criaRota(@RequestBody @Valid RotaForm rotaForm){

        Rota rota = rotaForm.toModel(aeroportoRepository);

        rotaRepository.save(rota);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rota.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
