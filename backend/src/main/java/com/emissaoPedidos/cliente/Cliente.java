package com.emissaoPedidos.cliente;

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
@Table(name="cliente")
public class Cliente {

    @Id
    @Column(name="idCliente")
    private Integer id;

    @Column(name="nomeCliente")
    private String nome;
}
