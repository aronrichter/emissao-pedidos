<template>
  <div>
    <toolbar titulo="Emissão Pedidos"></toolbar><br>

    <div class="tamanhoPagina ">
    <p>Cliente</p>
    <select v-model="name" name="name">
      <option v-for="(value) in this.nomes" :value="(value._links.self.href).slice(-1)">
        {{ value.nome }}
      </option>
    </select>
  </div>

    <div class="tamanhoPagina is-pulled-right">
      <button @click="incluirPedido">Incluir</button>
    </div>
      <modal v-show="isModalVisible"
             @close="closeModal"
             :idPedido="this.numeroPedido"/>
    <grid :itensPedido="this.itensPedido"></grid>
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
    };
  },
  created() {
    let promise = this.$http.get('http://localhost:9010/clientes')
      .then(res => res.json())
      .then(data => this.nomes = data._embedded.clientes);

    promise = this.$http.get(`http://localhost:9010/pedidosItem/pedidoId/${this.id}`)
      .then(res => (res.json())
      .then(data => this.itensPedido = data))
  },
  methods: {
    incluirPedido() {
      console.log(this.id);
      /*
      let queryJson = this.montaJson();
      let requisicao = this.$http.post('http://localhost:9010/pedidos', queryJson)
        .then((response) =>{
            this.numeroPedido = Number((response.body._links.pedido.href).slice(-2));
        });
      this.isModalVisible = true;
      */
    },
    closeModal() {
      this.isModalVisible = false;
    },
    montaJson() {
      return `{
        "pedido": {
          "cliente": {"id":${this.name}}
        }
      }`;
    }
  }
}
</script>

<style>
  .tamanhoPagina {
    margin-left: 20%;
    margin-right: 20%;
  }
</style>
