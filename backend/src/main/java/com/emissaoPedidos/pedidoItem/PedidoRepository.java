package com.emissaoPedidos.pedidoItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoItem, Integer> {

}
