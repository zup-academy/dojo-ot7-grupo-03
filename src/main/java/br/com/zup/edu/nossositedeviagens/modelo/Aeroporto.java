package br.com.zup.edu.nossositedeviagens.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeroporto aeroporto = (Aeroporto) o;
        return id.equals(aeroporto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
