<template>
  <div class="tamanhoPagina">
    <table width="100%">
      <thead>
        <tr class="bordaTabela">
          <th width="25%">Produto</th>
          <th width="25%">Preço</th>
          <th width="10%">Quantidade</th>
          <th width="20%">Rentabilidade</th>
        </tr>
      </thead>
      <tbody>
        <tr class="bordaTabela" v-for="item in itensPedido" @click="teste">
          <td>{{ item.produto.nome }}</td>
          <td>R$ {{ item.precoUnitario }}</td>
          <td>{{ item.quantidade }}</td>
          <td v-if="item.rentabilidade === 'R'">Ruim</td>
          <td v-if="item.rentabilidade === 'B'">Boa</td>
          <td v-if="item.rentabilidade === 'O'">Ótima</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props: {
      itensPedido: {}
    },
  data() {
    return {
    }
  },
  methods: {
    teste(){
      console.log("teste");
    }
  }
}
</script>

<style>
  .bordaTabela{
    border: 1px solid #333;
  }
</style>
