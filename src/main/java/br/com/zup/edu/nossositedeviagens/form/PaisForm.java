package br.com.zup.edu.nossositedeviagens.form;

import br.com.zup.edu.nossositedeviagens.modelo.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais converterForm(){
        return new Pais(this.nome);
    }
}
