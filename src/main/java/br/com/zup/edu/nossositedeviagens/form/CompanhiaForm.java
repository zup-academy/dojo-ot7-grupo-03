package br.com.zup.edu.nossositedeviagens.form;

import br.com.zup.edu.nossositedeviagens.modelo.Companhia;
import br.com.zup.edu.nossositedeviagens.modelo.Pais;
import br.com.zup.edu.nossositedeviagens.repositorio.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class CompanhiaForm {
    @NotBlank
    private String nome;
    @NotNull
    private Long paisId;

    public CompanhiaForm(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }
    public Optional<Companhia> converterForm(PaisRepository paisRepository){
        Optional<Pais> paisEncontrado = paisRepository.findById(paisId);


        if(paisEncontrado.isPresent()){
            Optional<Companhia> possivelCompanhia = Optional.of(new Companhia(nome,paisEncontrado.get()));
            return  possivelCompanhia;
        }

        return Optional.empty();
    }
}
