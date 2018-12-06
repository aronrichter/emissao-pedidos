import Home from './pages/home.vue';
import Pedido from './pages/pedido.vue';

export const routes = [

    { path: '', component: Home },
    { path: '/pedido/:id', component: Pedido }

];