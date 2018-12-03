package com.emissaoPedidos.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "clientes", collectionResourceRel = "clientes")
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {

    @Override
    @RestResource(exported = false)
    void delete(Cliente cliente);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer id);

    @Override
    @RestResource(exported = false)
    <S extends Cliente> S save(S s);
}
