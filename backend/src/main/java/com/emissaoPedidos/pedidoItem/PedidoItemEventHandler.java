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

    @HandleBeforeSave
    public void regraQuantidade(PedidoItem pedidoItem) {
        PedidoItemService.verificaQuantidade(pedidoItem);
    }
}
