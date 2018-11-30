package com.emissaoPedidos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.emissaoPedidos")
@ComponentScan("com.emissaoPedidos")
@EnableJpaRepositories("com.emissaoPedidos")
public class EmissaoPedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmissaoPedidosApplication.class, args);
    }
}
