import VueRouter from 'vue-router';
import routes from './routes';

export default new VueRouter({
  mode: 'history',
  routes: [
    { path: '/', redirect: '/pedido' },
    {
      path: '/pedido',
      name: 'application',
      children: routes,
    },
  ],
});
