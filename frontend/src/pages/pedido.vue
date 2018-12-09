<template>
  <div>
    <toolbar titulo="Emissão Pedidos"></toolbar><br>
    
    <div class="tamanhoPagina">
      <p>Número do Pedido: {{ this.itensPedido[0].pedido.id }}</p>
      <input class="input is-dark" v-model="this.itensPedido[0].pedido.cliente.nome" readonly>
    </div><br>

    <grid :itensPedido="this.itensPedido"></grid>

  </div>
</template>

<script>
import toolbar from '../components/toolbar.vue';
import grid from '../components/grid.vue';

export default {
  props: {
    id: String,
  },

  components: {
    'toolbar': toolbar,
    'grid': grid,
  },
  data() {
    return {
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
      console.log(this.itensPedido);
  },
}
</script>

<style>
  .tamanhoPagina {
    margin-left: 20%;
    margin-right: 20%;
  }
</style>
