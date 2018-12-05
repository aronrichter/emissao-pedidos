<template>
  <div class="tamanhoPagina ">
    <p>Cliente</p>
    <select>
      <option v-for="(value) in this.nomes" :value="(value._links.self.href).slice(-1)">
        {{ value.nome }}
      </option>
    </select>
  </div>
</template>

<script>
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
}
</script>

