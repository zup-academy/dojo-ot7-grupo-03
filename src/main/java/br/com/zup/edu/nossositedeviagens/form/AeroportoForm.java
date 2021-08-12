package br.com.zup.edu.nossositedeviagens.form;

import br.com.zup.edu.nossositedeviagens.annotation.ExistsId;
import br.com.zup.edu.nossositedeviagens.annotation.UniqueValue;
import br.com.zup.edu.nossositedeviagens.modelo.Aeroporto;
import br.com.zup.edu.nossositedeviagens.modelo.Pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AeroportoForm {

    @UniqueValue(domainClass = Aeroporto.class, fieldName = "nome")
    @NotBlank
    private String nome;

    @NotNull  @ExistsId(fieldName = "id", domainClass = Pais.class)
    private Long  paisId;

    public AeroportoForm(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }
}
