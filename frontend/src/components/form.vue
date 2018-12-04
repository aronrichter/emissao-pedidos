<template>
  <div class="tamanhoPagina ">
    <p>Cliente</p>
    <select>
      <option v-for="(value) in this.nomes" :key="(value._links.self.href).slice(-1)">
        {{ value.nome }}
      </option>
    </select>
    <div class="is-pulled-right">
      <button @click="teste">Incluir</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      nomes: [],
    }
  },
  methods:{
    teste() {
      console.log(this.$id);
    }
  },
  created() {
    let promise = this.$http.get('http://localhost:9010/clientes')
      .then(res => res.json())
      .then(data => this.nomes = data._embedded.clientes);
  },
}
</script>

