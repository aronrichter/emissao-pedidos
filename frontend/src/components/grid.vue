<template>
  <div class="tamanhoPagina">
    <div class="is-pulled-right">
      <button class="button is-dark is-small" @click="adicionarItem">Adicionar Itens</button>
    </div><br><br>
    <table width="100%">
      <thead>
        <tr class="bordaTabela">
          <th width="30%">Produto</th>
          <th width="20%">Preço</th>
          <th width="10%">Quantidade</th>
          <th width="20%">Rentabilidade</th>
        </tr>
      </thead>
      <tbody>
        <tr class="bordaTabela"
            v-for="item in itensPedido"
            :key="item.id"
            @click="alterarPedido(item.id)">
          <td>{{ item.produto.nome }}</td>
          <td>R$ {{ item.precoUnitario }}</td>
          <td>{{ item.quantidade }}</td>
          <td v-if="item.rentabilidade === 'R'">Ruim</td>
          <td v-if="item.rentabilidade === 'B'">Boa</td>
          <td v-if="item.rentabilidade === 'O'">Ótima</td>
        </tr>
      </tbody>
    </table><br>
    <div class="is-pulled-right">
      <button class="button is-dark is-small" @click="adicionarPedido">Adicionar Novo Pedido</button>
    </div>
    <modal v-show="isModalVisible"
          @close="closeModal"
          :idPedido="idPedidoGrid"
          :idPedidoItem="idPedidoItemGrid"
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
      idPedidoGrid: Number(/[^/]*$/.exec(window.location.href)[0]),
      idPedidoItemGrid: null,
    }
  },
  methods: {
    adicionarItem() {
      this.idPedidoItemGrid = null;
      this.isModalVisible = true;
    },
    alterarPedido(id) {
      this.idPedidoItemGrid = id;
      this.isModalVisible = true;
    },
    closeModal() {
      this.isModalVisible = false;
    },
    adicionarPedido() {
      window.location.href = `http://localhost:8080/`;
    }
  }
}
</script>

<style>
  .bordaTabela{
    border: 1px solid #333;
  }
</style>
