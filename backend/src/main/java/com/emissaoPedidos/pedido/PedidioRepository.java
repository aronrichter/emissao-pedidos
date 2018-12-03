package com.emissaoPedidos.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pedidos", collectionResourceRel = "pedidos")
public interface PedidioRepository extends JpaRepository<Pedido, Integer>, JpaSpecificationExecutor<Pedido> {

}
