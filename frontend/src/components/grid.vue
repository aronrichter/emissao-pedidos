<template>
  <div class="tamanhoPagina">
    <table width="100%">
      <thead>
        <tr class="bordaTabela">
          <th width="25%">Produto</th>
          <th width="25%">Preço</th>
          <th width="10%">Quantidade</th>
          <th width="20%">Rentabilidade</th>
        </tr>
      </thead>
      <tbody>
        <tr class="bordaTabela" 
            v-for="item in itensPedido" 
            @click="incluirPedido(item.id, item.produto.id, item.precoUnitario, item.quantidade)">
          <td>{{ item.produto.nome }}</td>
          <td>R$ {{ item.precoUnitario }}</td>
          <td>{{ item.quantidade }}</td>
          <td v-if="item.rentabilidade === 'R'">Ruim</td>
          <td v-if="item.rentabilidade === 'B'">Boa</td>
          <td v-if="item.rentabilidade === 'O'">Ótima</td>
        </tr>
      </tbody>
    </table>
    <modal v-show="isModalVisible" 
           @close="closeModal" 
           :idPedido="this.idPedidoItem"
           :idProduto="this.idProdutoItem"
           :precoProduto="this.precoProdutoItem"
           :quantidadeProduto="this.quantidadeProdutoItem"
           />
  </div>
</template>

<script>
import modal from '../components/modal.vue';

export default {
  props: {
      itensPedido: {}
    },
    components: {
    'modal': modal,
  },
  data() {
    return {
      isModalVisible: false,
      idProdutoItem: null,
      precoProdutoItem: null,
      quantidadeProdutoItem: null,
      idPedidoItem: null,
    }
  },
  methods: {
    incluirPedido(itemPedido, idProduto, preco, qtd) {
      this.idPedidoItem = itemPedido;
      this.idProdutoItem = idProduto;
      this.precoProdutoItem = preco;
      this.quantidadeProdutoItem = qtd;
      this.isModalVisible = true;
    },
    closeModal() {
      this.isModalVisible = false;
    },
  }
}
</script>

<style>
  .bordaTabela{
    border: 1px solid #333;
  }
</style>
