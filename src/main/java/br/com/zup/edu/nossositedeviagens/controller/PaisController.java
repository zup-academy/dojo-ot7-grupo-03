package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.form.PaisForm;
import br.com.zup.edu.nossositedeviagens.modelo.Pais;
import br.com.zup.edu.nossositedeviagens.repositorio.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid PaisForm form){
        Pais pais = form.converterForm();
        paisRepository.save(pais);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
