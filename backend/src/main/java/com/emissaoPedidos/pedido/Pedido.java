package com.emissaoPedidos.pedido;

import com.emissaoPedidos.cliente.Cliente;
import com.emissaoPedidos.produto.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Pedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Produto produto;
}
