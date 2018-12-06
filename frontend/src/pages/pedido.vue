<template>
  <div>
    <toolbar titulo="Emissão Pedidos"></toolbar><br>

    <div class="tamanhoPagina">
      <p>Cliente</p>
      <input class="input is-dark" v-model="this.itensPedido[0].pedido.cliente.nome" readonly>
    </div><br>

    <div class="tamanhoPagina is-pulled-right">
      <button class="button is-dark is-small" @click="incluirPedido">Adicionar Itens</button>
    </div><br><br>

    <grid :itensPedido="this.itensPedido"></grid>

    <modal v-show="isModalVisible" @close="closeModal" :idPedido="this.itensPedido[0].pedido.id"/>
  </div>
</template>

<script>
import toolbar from '../components/toolbar.vue';
import grid from '../components/grid.vue';
import modal from '../components/modal.vue';

export default {
  props: {
    id: String,
  },

  components: {
    'toolbar': toolbar,
    'grid': grid,
    'modal': modal,
  },
  data() {
    return {
      isModalVisible: false,
      name: null,
      nomes: [],
      numeroPedido: null,
      itensPedido: [],
      cliente: ''
    };
  },
  created() {
    let promise = this.$http.get(`https://emissaopedido.herokuapp.com/pedidosItem/pedidoId/${this.id}`)
      .then(res => (res.json())
      .then(data => this.itensPedido = data));
  },
  methods: {
    incluirPedido() {
      this.isModalVisible = true;
    },
    closeModal() {
      this.isModalVisible = false;
    },
  }
}
</script>

<style>
  .tamanhoPagina {
    margin-left: 20%;
    margin-right: 20%;
  }
</style>
