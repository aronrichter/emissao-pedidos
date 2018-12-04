package com.emissaoPedidos.pedidoItem;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/pedidosItem")
public class PedidoItemServiceImpl {

    PedidoItemRepository pedidoItemRepository;

    public PedidoItemServiceImpl(PedidoItemRepository pedidoItemRepository){
        this.pedidoItemRepository = pedidoItemRepository;
    }

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

    @GetMapping("pedidoId/{pedidoId}")
    public List<PedidoItem> getPedidosItem(@PathVariable Integer pedidoId) {
        return pedidoItemRepository.findByPedidoId(pedidoId);
    }
}
