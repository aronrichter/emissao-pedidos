package com.emissaoPedidos.pedidoItem;

public class PedidoItemService {

    public static void verificaQuantidade(PedidoItem pedidoItem) {
        if (pedidoItem.getProduto().getMultiplo() != null) {
            if (pedidoItem.getQuantidade() % pedidoItem.getProduto().getMultiplo() != 0) {
                throw new PedidoItemException("A quantidade de itens tem de ser multiplo de " + pedidoItem.getProduto().getMultiplo().toString());
            }
        }
    }
    public static void aplicaRentabilidade(PedidoItem pedidoItem) {
        Character rentabilidade = verificaRentabilidade(pedidoItem.getProduto().getPreco(), pedidoItem.getPrecoUnitario());
        pedidoItem.setRentabilidade(rentabilidade);
    }

    public static Character verificaRentabilidade(Float precoOriginal, Float precoCompra) {
        char tipoRentabilidade;
        if (precoCompra > precoOriginal)
            tipoRentabilidade = 'O';
        else{
            if(calculaPercentual(precoOriginal, precoCompra) <= 10){
                tipoRentabilidade = 'B';
            }
            else{
                tipoRentabilidade = 'R';
            }
        }
        return tipoRentabilidade;
    }
    public static Integer calculaPercentual(Float precoOriginal, Float precoCompra) {
        return Math.round((1 - precoCompra / precoOriginal) * 100);
    }

}
