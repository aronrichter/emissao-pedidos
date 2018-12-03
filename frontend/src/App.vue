<template>
  <div>
    <toolbar titulo="Emissão Pedidos"></toolbar><br>

    <div class="is-grouped tamanhoPagina">
      <div class="select is-dark is-pulled-left">  
        <select>
          <option v-for="(value) in this.nomes" :key="(value._links.self.href).slice(-1)">
            {{ value.nome }}
          </option>
        </select>
      </div>

      <div class="is-pulled-right">
        <button class="button is-success">Incluir</button>
        <button class="button is-danger" @click="teste">Excluir</button>
      </div>
    </div>
    <grid-line></grid-line>
  </div>
</template>

<script>
import toolbar from './components/toolbar.vue';
import gridLabel from './components/gridLabel.vue';
import gridLine from './components/gridLine.vue';

export default {
  data() {
    return {
      nomes: [],
    }
  },
  created() {
    let promise = this.$http.get('http://localhost:9010/clientes')
      .then(res => res.json())
      .then(data => this.nomes = data._embedded.clientes);
  },
  components: {
    'toolbar': toolbar,
    'gridLabel': gridLabel,
    'gridLine': gridLine
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
