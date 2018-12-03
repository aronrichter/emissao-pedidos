package com.emissaoPedidos.main;

import com.emissaoPedidos.pedidoItem.PedidoItemService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PedidoItemTest {

    @Test
    public void testeCalculaPercentual(){
        assertThat(PedidoItemService.calculaPercentual(10.0f, 9.0f)).isEqualTo(10);
    }

    @Test
    public void testeVerificaRentabilidadeBoa(){
        assertThat(PedidoItemService.verificaRentabilidade(10.0f, 9.0f)).isEqualTo('B');
        assertThat(PedidoItemService.verificaRentabilidade(10.0f, 9.5f)).isEqualTo('B');
        assertThat(PedidoItemService.verificaRentabilidade(10.0f, 10.0f)).isEqualTo('B');
    }

    @Test
    public void testeVerificaRentabilidadeOtima(){
        assertThat(PedidoItemService.verificaRentabilidade(10.0f, 10.1f)).isEqualTo('O');
        assertThat(PedidoItemService.verificaRentabilidade(10.0f, 11.0f)).isEqualTo('O');
    }

    @Test
    public void testeVerificaRentabilidadeRuim(){
        assertThat(PedidoItemService.verificaRentabilidade(10.0f, 8.9f)).isEqualTo('R');
        assertThat(PedidoItemService.verificaRentabilidade(10.0f, 7.0f)).isEqualTo('R');
    }

}
