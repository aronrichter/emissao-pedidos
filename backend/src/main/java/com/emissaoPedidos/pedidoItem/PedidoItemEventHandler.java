package com.emissaoPedidos.pedidoItem;

import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class PedidoItemEventHandler {

    private PedidoItemRepository pedidoItemRepository;

    public PedidoItemEventHandler(PedidoItemRepository pedidoItemRepository) {
        this.pedidoItemRepository = pedidoItemRepository;
    }

    @HandleBeforeCreate
    public void regraQuantidadeInsercao(PedidoItem pedidoItem) {
        PedidoItemService.verificaQuantidade(pedidoItem);
    }

    @HandleBeforeSave
    public void regraQuantidadeAtualizacao(PedidoItem pedidoItem) {
        PedidoItemService.verificaQuantidade(pedidoItem);
    }

    @HandleBeforeCreate
    public void regraRentabilidadeInsercao(PedidoItem pedidoItem) {
        PedidoItemService.aplicaRentabilidade(pedidoItem);
    }

    @HandleBeforeSave
    public void regraRentabilidadeAtualizacao(PedidoItem pedidoItem) {
        PedidoItemService.aplicaRentabilidade(pedidoItem);
    }
}
