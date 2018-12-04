package com.emissaoPedidos.pedidoItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "pedidoItens", collectionResourceRel = "pedidoItens")
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer>, JpaSpecificationExecutor<PedidoItem> {

    List<PedidoItem> findByPedidoId(Integer id);
}
