package com.emissaoPedidos.pedidoItem;

import com.emissaoPedidos.pedido.Pedido;
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
public class PedidoItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;

    private Integer quantidade;

    private Float precoUnitario;

    private String rentabilidade;
}
