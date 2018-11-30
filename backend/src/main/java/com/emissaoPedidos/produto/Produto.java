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
@Table(name="produto")
public class Produto {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="preco")
    private Float preco;

    @Column(name="multiplo")
    private Integer multiplo;
}
