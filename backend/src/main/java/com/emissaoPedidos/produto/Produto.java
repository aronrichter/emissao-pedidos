package com.emissaoPedidos.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produto {

    @Id
    private Integer id;

    private String nome;

    private Float preco;

    private Integer multiplo;
}
