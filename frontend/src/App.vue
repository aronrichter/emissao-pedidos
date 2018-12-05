<template>
  <div>
    <toolbar titulo="Emissão Pedidos"></toolbar><br>
    <forms></forms>
    <div class="tamanhoPagina is-pulled-right">
      <button @click="teste">Incluir</button>
    </div>
    <grid></grid>
      <modal v-show="isModalVisible"
            @close="closeModal"/>
  </div>
</template>

<script>
import toolbar from './components/toolbar.vue';
import grid from './components/grid.vue';
import form from './components/form.vue';
import modal from './components/modal.vue';

export default {
  components: {
    'toolbar': toolbar,
    'grid': grid,
    'forms': form,
    'modal': modal,
  },
  data() {
    return {
      isModalVisible: false,
    };
  },
  methods: {
    teste() {
      let queryJson = this.montaJson();
      let requisicao = this.$http.post('http://localhost:9010/pedidos', queryJson);
      console.log(requisicao);
      console.log(this.teste12);
      this.isModalVisible = true;
    },
    closeModal() {
      this.isModalVisible = false;
    },
    montaJson() {
      return `{
        "pedido": {
          "cliente": {"id":1}
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
