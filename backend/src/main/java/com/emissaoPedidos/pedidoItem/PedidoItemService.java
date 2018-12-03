package com.emissaoPedidos.pedidoItem;

public class PedidoItemService {

    public static void verificaQuantidade(PedidoItem pedidoItem) {
        if (pedidoItem.getProduto().getMultiplo() != null) {
            if ((pedidoItem.getQuantidade() % pedidoItem.getProduto().getMultiplo()) != 0) {
                throw new PedidoItemException("A quantidade de itens tem de ser multiplo de "+ pedidoItem.getProduto().getMultiplo().toString());
            }
        }
    }
}
