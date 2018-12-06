package com.emissaoPedidos.pedidoItem;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
