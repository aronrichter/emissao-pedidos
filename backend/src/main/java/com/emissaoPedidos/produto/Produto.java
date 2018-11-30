package com.emissaoPedidos.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Produto {

    @Id
    private Integer id;

    private String nome;

    private Float preco;

    private Integer multiplo;
}
