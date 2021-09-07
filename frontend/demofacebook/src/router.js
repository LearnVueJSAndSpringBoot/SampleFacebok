import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/layouts/Home.vue'
import Search from '@/layouts/Search.vue'

Vue.use(VueRouter)

export const router = new VueRouter({
    routes: [
        { path: '/', name: 'home', component: Home },
        { path: '/search', name: 'search', component: Search },
    ]
})