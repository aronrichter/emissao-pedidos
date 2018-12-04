<template>
  <div class="tamanhoPagina">
    <table width="100%">
      <thead>
        <tr class="bordaTabela">
          <th width="10%">ID</th>
          <th width="25%">Produto</th>
          <th width="25%">Preço</th>
          <th width="10%">Quantidade</th>
          <th width="20%">Rentabilidade</th>
        </tr>
      </thead>
      <tbody>
        <tr class="bordaTabela">
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      produtos: [],
    }
  },
  /*
  created() {
    let promise = this.$http.get('http://localhost:9010/produtos')
      .then(res => res.json())
      .then(data => this.produtos = data._embedded.produtos);
  }
  */
}
</script>

<style>
  .bordaTabela{
    border: 1px solid #333;
  }
</style>