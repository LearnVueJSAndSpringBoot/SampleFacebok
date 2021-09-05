import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from './components/Home.vue'
import Add from './components/Add.vue'

Vue.use(VueRouter)

export const router = new VueRouter({
    routes: [
        { path: '/', name: 'home', component: Home },
        { path: '/add', name: 'add', component: Add },
    ]
})