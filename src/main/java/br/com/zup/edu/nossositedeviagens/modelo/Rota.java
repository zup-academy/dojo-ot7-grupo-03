package br.com.zup.edu.nossositedeviagens.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private Aeroporto origem;
    @NotNull
    private Aeroporto destino;

    @NotNull @Positive
    private Integer duracao;


    @Deprecated
    public Rota() {
    }

    public Rota(String nome, Aeroporto origem, Aeroporto destino, Integer duracao) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.duracao = duracao;
    }
}
