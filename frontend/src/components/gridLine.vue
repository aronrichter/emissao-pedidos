<template>
  <div class="columns">
    <div class="column is-3">
      <div class="select is-dark">
        <select>
          <option v-for="(value) in this.produtos" :key="(value._links.self.href).slice(-1)">
            {{ value.nome }}
          </option>
        </select>
      </div>
    </div>
    <div class="column field has-addons is-4">
      <p class="control">
        <a class="button is-static">$</a>
      </p>
      <p class="control is-expanded">
        <input class="input is-dark" type="number">
      </p>
    </div>
    <div class="column is-2">
        <input class="input is-dark" type="number">
    </div>    
  </div> 
</template>

<script>
export default {
  data() {
    return {
      produtos: [],
    }
  },
  created() {
    let promise = this.$http.get('http://localhost:9010/produtos')
      .then(res => res.json())
      .then(data => this.produtos = data._embedded.produtos);
  }
}
</script>

<style>
  .columns{
    margin-left: 20%;
    margin-right: 20%;
  }
</style>

