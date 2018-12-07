<template>
  <div class="modal-backdrop">
    <div class="modal">
      <p>Insira os dados dao pedido:</p><br>
      <div class="field is-horizontal">
        <div class="field-label is-small">
          <label>Produto</label>
        </div>
        <div class="control ">
          <div class="select is-dark is-small">
            <select v-model="name" name="name">
              <option v-for="value in this.produtos" :value="(value._links.self.href).slice(-1)">{{ value.nome }}</option>
            </select>
          </div>
        </div>
      </div>

      <div class="field is-horizontal">
        <div class="field-label is-small">
          <label>Preço</label>
        </div>
        <input class="input is-dark is-small" v-model="preco" type="number" placeholder="Preço R$" min=0>
      </div>

      <div class="field is-horizontal">
        <div class="field-label is-small">
          <label>Quantidade</label>
        </div>
        <input class="input is-dark is-small" v-model="quantidade" type="number" placeholder="Quantidade">
        </div>
        <br>
        <div class="is-grouped">
          <button class="button is-success is-danger is-small" @click="cancelar">Cancelar</button>
          <button class="button is-success is-small" @click="confirmar">Confirmar</button>
        </div>

    </div>
  </div>
</template>

<script>
  export default {
    props: {
      idPedido: { type: Number },
      idPedidoItem: { type: Number },
    },
    data() {
      return {
        quantidade: null,
        preco: null,
        name: null,
        produtos: [],
      };
    },
    methods: {
      cancelar() {
        this.$emit('close');
      },

      confirmar() {
        if (!this.name) {
          alert("Selecione um produto");
          return;
        }
        if (this.quantidade <= 0) {
          alert("Valor tem de ser maior que zero!");
          return;
        }
        //validação numero
        if (this.idPedidoItem){
          this.alterarPedido();
        }else {
          this.incluirPedido();
        }
      },

      alterarPedido(){
         let queryJson = this.montaJson();
         let requisicao = this.$http.patch(`https://emissaopedido.herokuapp.com/pedidoItens/${this.idPedidoItem}`, queryJson)
          .then(() => {
            window.location.reload();
          })
          .catch(error => {
            if (error.status == 400) {
              alert(error.body.message);
            }
        });
      },

      incluirPedido() {
        let queryJson = this.montaJson();
        let requisicao = this.$http.post(`https://emissaopedido.herokuapp.com/pedidoItens`, queryJson)
          .then(() => {
            window.location.href = `http://localhost:8080/pedido/${this.idPedido}`;
          })
          .catch(error => {
            if (error.status == 400) {
              alert(error.body.message);
            }
        });
      },

      montaJson() {
        return `{
          "pedido": "pedido/${this.idPedido}",
          "produto": "produto/${this.name}",
          "quantidade": ${this.quantidade},
          "precoUnitario": ${this.preco}
        }`;
      }
    },
    created() {
      let promise = this.$http.get('https://emissaopedido.herokuapp.com/produtos')
        .then(res => res.json())
        .then(data => this.produtos = data._embedded.produtos);
    },
  };
</script>

<style>
.modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.3);
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .modal {
    background: #FFFFFF;
    box-shadow: 2px 2px 20px 1px;
    margin: 250px 400px 250px 400px;
    overflow-x: auto;
    display: flex;
  }
</style>
