package com.emissaoPedidos.pedidoItem;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RepositoryRestController
@RequestMapping("/pedidosItem")
public class PedidoItemController {

    PedidoItemRepository pedidoItemRepository;

    public PedidoItemController(PedidoItemRepository pedidoItemRepository){
        this.pedidoItemRepository = pedidoItemRepository;
    }

    @GetMapping("pedidoId/{pedidoId}")
    @ResponseBody
    public List<PedidoItem> getPedidosItem(@PathVariable Integer pedidoId) {
        return pedidoItemRepository.findByPedidoId(pedidoId);
    }
}
