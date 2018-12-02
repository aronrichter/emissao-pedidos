<template>
  <div>
    <toolbar titulo="Emissão Pedidos"></toolbar>
    <br>
    <forms></forms>
    <br>
    <gridLabel></gridLabel>
    <gridLine></gridLine>
  </div>
</template>

<script>
import toolbar from './components/toolbar.vue';
import form from './components/form.vue';
import gridLabel from './components/gridLabel.vue';
import gridLine from './components/gridLine.vue';

export default {
  components: {
    'toolbar': toolbar,
    'forms': form,
    'gridLabel': gridLabel,
    'gridLine': gridLine
  }
}
</script>

<style>
  .columns{
    margin-left: 20%;
    margin-right: 20%;
  }
</style>
