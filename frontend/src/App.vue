<template>
  <div>
    <toolbar titulo="Emissão Pedidos"></toolbar><br>
    <forms></forms><br>
    <grid></grid>
  </div>
</template>

<script>
import toolbar from './components/toolbar.vue';
import grid from './components/grid.vue';
import form from './components/form.vue';

export default {
  components: {
    'toolbar': toolbar,
    'grid': grid,
    'forms': form,
  },
  methods: {
    teste() {
      console.log("Teste");
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
