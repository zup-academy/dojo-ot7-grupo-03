package br.com.zup.edu.nossositedeviagens.form;

import br.com.zup.edu.nossositedeviagens.modelo.Aeroporto;
import br.com.zup.edu.nossositedeviagens.modelo.Rota;
import br.com.zup.edu.nossositedeviagens.repositorio.AeroportoRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RotaForm {

    private String nome;

    @NotNull
    private Long aeroportoOrigemId;
    @NotNull
    private Long aeroportoDestinoId;

    @NotNull @Positive
    private Integer duracao;


    public RotaForm(String nome, Long aeroportoOrigemId, Long aeroportoDestinoId, Integer duracao) {
        this.nome = nome;
        this.aeroportoOrigemId = aeroportoOrigemId;
        this.aeroportoDestinoId = aeroportoDestinoId;
        this.duracao = duracao;
    }

    public Rota toModel(AeroportoRepository aeroportoRepository){
        Aeroporto origem = aeroportoRepository.findById(aeroportoOrigemId).get();
    }
}
