package br.com.zup.edu.nossositedeviagens.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Companhia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private LocalDateTime instanteCriacao = LocalDateTime.now();

    @NotNull
    @ManyToOne
    private Pais pais;

    public Companhia(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
