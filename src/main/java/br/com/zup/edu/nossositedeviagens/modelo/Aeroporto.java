package br.com.zup.edu.nossositedeviagens.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Aeroporto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Aeroporto(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Deprecated
    public Aeroporto() {
    }
}
